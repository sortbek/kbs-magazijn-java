package bpp;

import java.util.ArrayList;

public class SimpleGreedy1 extends MySQLbpp {

    private Depository depository;
    private BoxDepository boxd;
    private ArrayList<Product> products;
    private ArrayList<Box> arrayBox;
    private MySQLbpp bpp = new MySQLbpp();

    public SimpleGreedy1() {
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

    public void runSg(int idorder) {
        int i = 0;
        int boxnr;
        Box b;
        boxnr = bpp.NewBox(20, idorder);

        Box box = new Box(boxnr, 20, 0, idorder, "busy");
        //int idBox, int size, int covered, int idorder, String status
        arrayBox.add(box);

        //Alle producten bij langsgaan
        while (i < products.size()) {
            int j = 0;
            Product product = products.get(i);
            if (product.GetBox() == 0) {

                String ready = "no";

                while ("no".equals(ready)) {
                    b = arrayBox.get(j);
                    int covered = b.getCovered();

                    if (((20 - covered) >= (product.Getsize())) && (b.getStatus() == "busy")) {
                        System.out.println("Het product past in doos " + b.getIdBox());

                        updateBox(b.getCovered() + product.Getsize(), false, b.getIdBox());
                        SetBox(b.getIdBox(), products.get(i).GetidProduct());

                        products.get(i).SetBox(b.getIdBox());
                        b.setCovered(b.getCovered() + product.Getsize());

                        System.out.println("Product " + product.Getname() + " added to box " + b.getIdBox() + ".");

                        ready = "Yes";
                    } else {
                        if (covered == 20) {
                            b = arrayBox.get(j);
                            boxnr = b.getIdBox();
                            bpp.closeBox(boxnr);
                            b.setStatus("ready");
                        }
                        System.out.println("Het product past NIET in doos " + b.getIdBox());
                        System.out.println("nummer is nu " + j + " bestaat maar :" + arrayBox.size());
                        if (j + 1 < arrayBox.size()) {
                            j = j + 1;
                            System.out.println("Er zijn nog meer boxen volgende box");
                        } else {
                            System.out.println("Er is een nieuwe box aangemaakt");
                            boxnr = bpp.NewBox(20, idorder);
                            b = new Box(boxnr, 20, 0, idorder, "busy");
                            arrayBox.add(b);
                            System.out.println("Het product past in doos " + b.getIdBox());

                            updateBox(b.getCovered() + product.Getsize(), false, b.getIdBox());
                            SetBox(b.getIdBox(), products.get(i).GetidProduct());

                            products.get(i).SetBox(b.getIdBox());
                            b.setCovered(b.getCovered() + product.Getsize());

                            System.out.println("Product " + product.Getname() + " added to box " + b.getIdBox() + ".");
                            ready = "Yes";
                        }
                    }
                }
                System.out.println("de opdracht is nog " + depository.GetTotalSizeOrder() + " groot ");
            }
            i++;
        }

        int h = 0;
        while (arrayBox.size() > h) {
            b = arrayBox.get(h);
            boxnr = b.getIdBox();
            bpp.closeBox(boxnr);
            h++;
        }

    }
}
