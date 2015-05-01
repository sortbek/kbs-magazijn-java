package bpp;

import java.util.ArrayList;

public class CompleteEnumeration {

  private Depository depository;
    private BoxDepository boxd;
    private ArrayList<Product> producten;
    private ArrayList<Box> arrayBox;
    private Box boxA;
    private Box boxB;
    private Box boxC;

    public CompleteEnumeration() {
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

    public void runCe() {
        
    }


}
