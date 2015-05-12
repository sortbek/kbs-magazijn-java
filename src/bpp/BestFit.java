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
    private int time;
//    public BestFit() {
//
//    }

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

    public void BF(int idorder){
    // controleren op order
        int boxnr = 0;
        int sizeproduct = 0;
        int productnr = 0;
        int sizeorder = depository.GetSizeOrder();
        int sizebox = 0;
        

        while(sizeorder>0){
            int sizeb;
            int coverd;
            String status;
            int nrProduct;
            
            if (sizeorder > 15){
            sizeb = 20;
            }
            else if(sizeorder > 5){
            sizeb = 10;
            }
            else {
            sizeb = 5;
            }  
            
        // nieuwe box maken in database
        boxnr = bpp.NewBox(sizeb, idorder);
        
        // nieuwe box maken in arraylist
        Box box = new Box(boxnr, sizeb, 0, idorder,"busy");
        arrayBox.add(box);
        sizebox = sizeb;   
        status = box.getStatus();
            
        // grootste product opvragen en productnr erbij zoeken  
        sizeproduct = depository.GetBigProduct(); 
        
        // arraylist bij product en productnr opvragen.
        nrProduct = depository.GetProductWithSize(sizeproduct);
        p = producten.get(nrProduct);
        productnr = p.GetidProduct();
        
         // boxnr aanpassen in arraylist
        p.SetBox(boxnr);
        
        // boxnr bij product aanpassen in database
        bpp.SetBox(boxnr, productnr);
                
        // boxcoverd wordt aangepast in de arraylist
        coverd = box.getCovered();
        box.setCovered(coverd + sizeproduct);
        
  

        sizeorder = sizeorder - sizeproduct;
        sizebox = sizebox - sizeproduct;
        System.out.println("ProductId: "+productnr+" Size: "+ sizeproduct +" is toegevoed" );
        System.out.println("Sizebox :"+sizebox +" Sizeorder : "+sizeorder);

            int sProduct;
            
        // kijk of er nog een product is die in de overgebleven ruimte past 
            sProduct = depository.GetSmallProduct(sizebox);
         
        while (sizebox >= sProduct && sizeorder > 0 && sProduct != 0){
            if (sProduct != 0){
            
       // grootste product opvragen en productnr erbij zoeken  
        sizeproduct = depository.GetSmallProduct(sizebox);
        
        // arraylist bij product en productnr opvragen.
        nrProduct = depository.GetProductWithSize(sizeproduct);
        p = producten.get(nrProduct);
        productnr = p.GetidProduct();
    
         // boxnr aanpassen in arraylist
        p.SetBox(boxnr);
        
        // boxnr bij product aanpassen in database
        bpp.SetBox(boxnr, productnr);
                
        // boxcoverd wordt aangepast in de arraylist
        coverd = box.getCovered();
        box.setCovered(coverd + sizeproduct);
        
  

        sizeorder = sizeorder - sizeproduct;
        sizebox = sizebox - sizeproduct;
        System.out.println("ProductId: "+productnr+" Size: "+ sProduct +" is toegevoed" );
        System.out.println("Sizebox :"+sizebox +" Sizeorder : "+sizeorder);
        }
        sProduct = depository.GetSmallProduct(sizebox);
        } 
        int c = (coverd + sizeproduct);
       // doos is zo vol mogelijk doos word gesloten database
       bpp.updateBox(c, true, boxnr);
       
       // doos word gesloten in arraylist
                box.setStatus("ready");
                System.out.println("box is dicht nr:"+ boxnr);
        }
        }}
               
      
         
    

    

