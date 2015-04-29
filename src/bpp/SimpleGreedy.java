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
            
            if (product.Getsize() < spaceLeftA) {
                System.out.println("Checking box A");
                updateBox(product.Getsize(), true, boxA.getIdBox());
            } else if (boxA.getCovered() + product.Getsize() < spaceLeftB) {
                System.out.println("Box A full, checking box B");
                updateBox(boxB.getCovered() + product.Getsize(), false, boxB.getIdBox());
            } else if (product.Getsize() < spaceLeftC) {
                System.out.println("Box B full, checking box C");
                System.out.println(spaceLeftC);
                updateBox(boxC.getCovered() + product.Getsize(), false, boxC.getIdBox());
            }
            updateBox(3, false, 1);
            
            System.out.println("\n");
            i++;
        }
    }
}
