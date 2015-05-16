package bpp;

import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.util.ArrayList;
import java.util.Collections;
import static java.util.Collections.*;

public class CompleteEnumeration extends MySQLbpp {

    private Depository depository;
    private BoxDepository boxd;
    private ArrayList<Product> products;
    private ArrayList<Box> arrayBox;
    private Box boxA;
    private Box boxB;
    private Box boxC;
    private String bestOptionOrder;
    private int bestOptionSpace;
    private int spaceUsed;
    private MySQLbpp bpp = new MySQLbpp();
    private int idorder;

    public CompleteEnumeration(int idorder) {
        this.idorder = idorder;
    }

    public void setBoxDepository(BoxDepository b) {
        int boxnr;
        boxd = b;
        boxnr = bpp.NewBox(20, idorder);
//        Box boxa = new Box(boxnr, 20, 0, idorder,"busy");
//        Box boxb = new Box(boxnr, 20, 0, idorder,"busy");
//        Box boxc = new Box(boxnr, 20, 0, idorder,"busy");
//        boxd.addBox(boxa);
//        boxd.addBox(boxb);
//        boxd.addBox(boxc);
        

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

    public void setBoxes(int idorder) {
        int boxAnr = NewBox(20, idorder);
        int boxBnr = NewBox(20, idorder);
        int boxCnr = NewBox(20, idorder);
        boxA = new Box(boxAnr, 20, 0, idorder, "busy");
        boxB = new Box(boxBnr, 20, 0, idorder, "busy");
        boxC = new Box(boxCnr, 20, 0, idorder, "busy");
        boxd.addBox(boxA);
        boxd.addBox(boxB);
        boxd.addBox(boxC);

        int boxASize = boxA.getSizeB();
        int boxBSize = boxB.getSizeB();
        int boxCSize = boxC.getSizeB();
        bestOptionSpace = boxASize + boxBSize + boxCSize;
    }

    public void calculateBestOption(String str) {
        calculateBestOption("", str);
    }

    public void calculateBestOption(String prefix, String str) {
        boolean useA, useB, useC;
        int n = str.length();
        useA = true;
        useB = false;
        useC = false;

        int spaceLeftA = boxA.getSizeB() - boxA.getCovered();
        int spaceLeftB = boxB.getSizeB() - boxB.getCovered();
        int spaceLeftC = boxC.getSizeB() - boxC.getCovered();
        int totalSpace = boxA.getSizeB() + boxB.getSizeB() + boxC.getSizeB();

        boolean ft = true;
        boolean ft2 = true;

        if (n == 0) {
            for (int i = 0; i < prefix.length(); i++) {
                int currP = Character.getNumericValue(prefix.charAt(i)) - 1;
                Product curr = products.get(currP);
                System.out.println("Product " + curr.Getname());
                if (spaceUsed + curr.Getsize() <= boxA.getSizeB()) {
                    System.out.println("A: Ervoor: " + spaceUsed);
                    spaceUsed += curr.Getsize();
                    System.out.println("A: Erna: " + spaceUsed);
                } else if (spaceUsed - boxA.getSizeB() + curr.Getsize() <= boxB.getSizeB()) {
                    if (ft) {
                        spaceUsed = boxA.getSizeB();
                        ft = false;
                    }
                    System.out.println("B: Ervoor: " + spaceUsed);
                    spaceUsed += curr.Getsize();
                    System.out.println("B: Erna: " + spaceUsed);
                } else if (spaceUsed - boxA.getSizeB() - boxB.getSizeB() + curr.Getsize() <= boxC.getSizeB()) {
                    if (ft2) {
                        spaceUsed = boxA.getSizeB() + boxB.getSizeB();
                        ft2 = false;
                    }
                    System.out.println("C: Ervoor: " + spaceUsed);
                    spaceUsed += curr.Getsize();
                    System.out.println("C: Erna: " + spaceUsed);
                } else {
                    System.out.println("Geen ruimte meer");
                }
                if (i == prefix.length() - 1) {
                    System.out.println("Huidige beste optie - Volgorde: " + bestOptionOrder + " Gebruikte ruimte: " + bestOptionSpace);
                    if (spaceUsed < bestOptionSpace) {
                        System.out.println("Volgorde: " + prefix + "\nGebruikte ruimte: " + spaceUsed);
                        bestOptionOrder = prefix;
                        bestOptionSpace = spaceUsed;
                    } else {
                        System.out.println("Huidige volgorde is niet beter");
                    }

                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                calculateBestOption(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
                System.out.println("\nTrying next option (resetting used space):");
                spaceUsed = 0;

            }
        }
    }

    public void runCe(int idorder) {
        String perm = "";
        int productAmount = products.size();
        if (productAmount > 3) {
            productAmount = 3;
        }

        System.out.println("Er zijn " + productAmount + " producten");
        for (int i = 1; i <= productAmount; i++) {
            perm += i;
        }

        calculateBestOption(perm);

        for (int n = 0; n < bestOptionOrder.length(); n++) {
            int currP = Character.getNumericValue(bestOptionOrder.charAt(n)) - 1;
            Product curr = products.get(currP);

            int spaceLeftA = boxA.getSizeB() - boxA.getCovered();
            int spaceLeftB = boxB.getSizeB() - boxB.getCovered();
            int spaceLeftC = boxC.getSizeB() - boxC.getCovered();

            //Doos A
            if (curr.Getsize() <= spaceLeftA) {
                System.out.println("Using box A");

                updateBox(boxA.getCovered() + curr.Getsize(), false, boxA.getIdBox());
                SetBox(boxA.getIdBox(), products.get(currP).GetidProduct());

                products.get(currP).SetBox(boxA.getIdBox());
                boxA.setCovered(boxA.getCovered() + curr.Getsize());

                System.out.println("Product " + curr.Getname() + " added to box A.");
            } //Doos B
            else if (curr.Getsize() <= spaceLeftB) {
                System.out.println("Box A full, using box B");

                updateBox(boxB.getCovered() + curr.Getsize(), false, boxB.getIdBox());
                boxB.setCovered(boxB.getCovered() + curr.Getsize());

                SetBox(boxB.getIdBox(), products.get(currP).GetidProduct());
                products.get(currP).SetBox(boxB.getIdBox());

                System.out.println("Product " + curr.Getname() + " added to box B.");
            } //Doos C
            else if (curr.Getsize() <= spaceLeftC) {
                System.out.println("Box A&B full, using box C");

                updateBox(boxC.getCovered() + curr.Getsize(), false, boxC.getIdBox());
                boxC.setCovered(boxC.getCovered() + curr.Getsize());

                SetBox(boxC.getIdBox(), products.get(currP).GetidProduct());
                products.get(currP).SetBox(boxC.getIdBox());

                System.out.println("Product " + curr.Getname() + " added to box C.");
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
        }
    }

}
