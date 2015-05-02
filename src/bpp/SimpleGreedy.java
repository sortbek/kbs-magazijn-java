package bpp;

import java.util.ArrayList;

public class SimpleGreedy extends MySQLbpp {

    private Depository depository;
    private BoxDepository boxd;
    private ArrayList<Product> products;
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
        products = depository.getList();
    }

    public Depository getDepository() {
        return this.depository;
    }

    public void setProducts(ArrayList<Product> p) {
        this.products = p;
    }

    public void setBoxes() {
        boxA = arrayBox.get(0);
        boxB = arrayBox.get(1);
        boxC = arrayBox.get(2);
    }

    public void runSg() {
        int i = 0;
        while (i < products.size()) {
            Product product = products.get(i);
            System.out.println(product.Getname());

            int spaceLeftA = boxA.getSizeB() - boxA.getCovered();
            int spaceLeftB = boxB.getSizeB() - boxB.getCovered();
            int spaceLeftC = boxC.getSizeB() - boxC.getCovered();

            //Doos A
            if (product.Getsize() <= spaceLeftA) {
                System.out.println("Using box A");
                
                updateBox(boxA.getCovered() + product.Getsize(), false, boxA.getIdBox());
                SetBox(boxA.getIdBox(), products.get(i).GetidProduct());
                
                products.get(i).SetBox(boxA.getIdBox());
                boxA.setCovered(boxA.getCovered() + product.Getsize());
                
                System.out.println("Product " + product.Getname() + " added to box A.");
            } //Doos B
            else if (product.Getsize() <= spaceLeftB) {
                System.out.println("Box A full, using box B");
                
                updateBox(boxB.getCovered() + product.Getsize(), false, boxB.getIdBox());
                boxB.setCovered(boxB.getCovered() + product.Getsize());
                
                SetBox(boxB.getIdBox(), products.get(i).GetidProduct());
                products.get(i).SetBox(boxB.getIdBox());
                
                System.out.println("Product " + product.Getname() + " added to box B.");
            } //Doos C
            else if (product.Getsize() <= spaceLeftC) {
                System.out.println("Box A&B full, using box C");
                
                updateBox(boxC.getCovered() + product.Getsize(), false, boxC.getIdBox());
                boxC.setCovered(boxC.getCovered() + product.Getsize());
                
                SetBox(boxC.getIdBox(), products.get(i).GetidProduct());
                products.get(i).SetBox(boxC.getIdBox());
                
                System.out.println("Product " + product.Getname() + " added to box C.");
            } else {
                System.out.println("Geen ruimte meer over.");
            }
            System.out.print("\n");
            
            if (boxA.getCovered() > 0) {
                closeBox(boxA.getIdBox());
                boxA.setStatus("ready");
            }
            if (boxB.getCovered() > 0) {
                closeBox(boxB.getIdBox());
                boxB.setStatus("ready");
            }
            if (boxC.getCovered() > 0) {
                closeBox(boxC.getIdBox());
                boxC.setStatus("ready");
            }
            i++;
        }
    }
}
