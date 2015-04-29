package bpp;

import java.util.ArrayList;

public class SimpleGreedy extends MySQLbpp {

    private Depository depository;
    private BoxDepository boxd;
    private ArrayList<Product> producten;
    private ArrayList<Box> arrayBox;
    private Box boxA;
    private Box boxB;
    private Box boxC;

    public SimpleGreedy() {
    }

    public void setBoxDepository(BoxDepository b) {
        boxd = b;
        arrayBox = boxd.getList();
        int a = arrayBox.size();
        if (a > 2) {
            System.out.println("Let op er zijn te veel dozen!!");
        }

    }

    public void setDepository(Depository b) {
        this.depository = b;
        producten = depository.getList();
    }

    public Depository getDepository() {
        return this.depository;
    }

    public void setProducten(ArrayList<Product> p) {
        this.producten = p;
    }

    public void setBoxes() {
        boxA = arrayBox.get(0);
        boxB = arrayBox.get(1);
        boxC = arrayBox.get(2);
    }

    public void runSg() {
        int i = 0;
        while (i < producten.size()) {
            Product product = producten.get(i);
            System.out.println(product.Getname());

            int spaceLeftA = boxA.getSizeB() - boxA.getCovered();
            int spaceLeftB = boxB.getSizeB() - boxB.getCovered();
            int spaceLeftC = boxC.getSizeB() - boxC.getCovered();

            //Doos A
            if (product.Getsize() < spaceLeftA) {
                System.out.println("Using box A");
                updateBox(boxA.getCovered() + product.Getsize(), false, boxA.getIdBox());
                System.out.println("Product " + product.Getname() + " added to box A.");
                removeProduct(product.GetidProduct());
            } //Doos B
            else if (product.Getsize() < spaceLeftB) {
                System.out.println("Box A full, using box B");
                updateBox(boxB.getCovered() + product.Getsize(), false, boxB.getIdBox());
                System.out.println("Product " + product.Getname() + " added to box B.");
                removeProduct(product.GetidProduct());
            } //Doos C
            else if (product.Getsize() < spaceLeftC) {
                System.out.println("Box A&B full, using box C");
                updateBox(boxC.getCovered() + product.Getsize(), false, boxC.getIdBox());
                System.out.println("Product " + product.Getname() + " added to box C.");
                removeProduct(product.GetidProduct());
            } else {
                System.out.println("Geen ruimte meer over.");
            }
            i++;
        }
    }
}
