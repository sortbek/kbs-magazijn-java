/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpp;

import java.util.ArrayList;

/**
 *
 * @author Marjolein
 */
public class BestFit {

    private Depository depository;
    private BoxDepository boxd;
    private ArrayList<Product> producten;
    private ArrayList<Box> arrayBox;
    private Product p;
    private MySQLbpp bpp = new MySQLbpp();

    public void setBoxDepository(BoxDepository b) {
        this.boxd = b;
        this.arrayBox = boxd.getList();
    }

    public void setDepository(Depository b) {
        this.depository = b;
        this.producten = depository.getList();
    }

    public Depository getDepository() {
        return this.depository;
    }

    public void BF(int idorder) {
        int boxnr = 0;
        int sizeproduct = 0;
        int productnr = 0;
        int sizeorder = depository.GetTotalSizeOrder();
        int sizebox = 0;

        while (sizeorder > 0) {
            int sizeb = 20;
            int covered;
            String status;
            int nrProduct;

//            if (sizeorder >0){
//            sizeb = 20;
//            }
//            else {
//            sizeb = 0;
//            }
//            
//            if (sizeorder > 15){
//            sizeb = 20;
//            }
//            else if(sizeorder > 5){
//            sizeb = 10;
//            }
//            else {
//            sizeb = 5;
//            }  
//            
            // Make new Box in Database
            boxnr = bpp.NewBox(sizeb, idorder);

            // Make new Box in Depository
            Box box = new Box(boxnr, sizeb, 0, idorder, "busy");
            arrayBox.add(box);
            sizebox = sizeb;
            status = box.getStatus();

            // Get size form biggest product
            sizeproduct = depository.GetBigProduct();

            // Get productnummer form biggest product
            nrProduct = depository.GetProductWithSize(sizeproduct);
            p = producten.get(nrProduct);
            productnr = p.GetidProduct();

            //Place product in box
            // Set boxnr in ArrayList
            p.SetBox(boxnr);

            // Set boxnr in Database
            bpp.SetBox(boxnr, productnr);

            // set coverd in ArrayList
            covered = box.getCovered();
            box.setCovered(covered + sizeproduct);

            sizeorder = sizeorder - sizeproduct;
            sizebox = sizebox - sizeproduct;
            System.out.println("ProductId: " + productnr + " Size: " + sizeproduct + " is toegevoed");
            System.out.println("Sizebox :" + sizebox + " Sizeorder : " + sizeorder);

            int sProduct;

            // Look if there is a product who fit into the box.  
            sProduct = depository.GetSmallProduct(sizebox);

            while (sizebox >= sProduct && sizeorder > 0 && sProduct != 0) {
                if (sProduct != 0) {

                    // Get the size of the product who fit into the box. 
                    sizeproduct = depository.GetSmallProduct(sizebox);

                    // Get productnr from the product who fit into the box.
                    nrProduct = depository.GetProductWithSize(sizeproduct);
                    p = producten.get(nrProduct);
                    productnr = p.GetidProduct();

                    // SetBoxnr in Arraylist
                    p.SetBox(boxnr);

                    // Set boxnr in Database
                    bpp.SetBox(boxnr, productnr);

                    // Set coverd in ArrayList
                    covered = box.getCovered();
                    box.setCovered(covered + sizeproduct);

                    sizeorder = sizeorder - sizeproduct;
                    sizebox = sizebox - sizeproduct;
                    System.out.println("ProductId: " + productnr + " Size: " + sProduct + " is toegevoed");
                    System.out.println("Sizebox :" + sizebox + " Sizeorder : " + sizeorder);
                }
                sProduct = depository.GetSmallProduct(sizebox);
            }
            int c = (covered + sizeproduct);
            // Update coverd in Database, And close Box in database
            bpp.updateBox(c, true, boxnr);

            // Close box in ArrayList
            box.setStatus("ready");
            System.out.println("box is dicht nr:" + boxnr + "\n\n");

        }
    }
}
