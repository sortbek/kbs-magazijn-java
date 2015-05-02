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
    private int maxSpaceLeft;

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

        int boxASize = boxA.getSizeB();
        int boxBSize = boxB.getSizeB();
        int boxCSize = boxC.getSizeB();
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
        int totalSpaceLeft = boxA.getSizeB() + boxB.getSizeB() + boxC.getSizeB();
        maxSpaceLeft = 0;

        if (n == 0) {
            for (int i = 0; i < prefix.length(); i++) {
                int currP = Character.getNumericValue(prefix.charAt(i)) - 1;
                Product curr = products.get(currP);
                if (useA) {
                    if (curr.Getsize() <= spaceLeftA) {
                        totalSpaceLeft = totalSpaceLeft - curr.Getsize();
                        boxA.setCovered(boxA.getCovered() + curr.Getsize());
                        if (i + 1 == products.size()) {
                            if (totalSpaceLeft > maxSpaceLeft) {
                                maxSpaceLeft = totalSpaceLeft;
                            }
                        }
                    } else {
                        useA = false;
                        useB = true;
                    }
                } else if (useB) {
                    if (curr.Getsize() <= spaceLeftB) {
                        if (currP + 1 == products.size()) {
                            if (totalSpaceLeft > maxSpaceLeft) {
                                maxSpaceLeft = totalSpaceLeft;
                            }
                        }
                    } else {
                        useB = false;
                        useC = true;
                    }
                } else if (useC) {
                    if (curr.Getsize() <= spaceLeftC) {
                        if (currP + 1 == products.size()) {
                            if (totalSpaceLeft > maxSpaceLeft) {
                                maxSpaceLeft = totalSpaceLeft;
                            }
                        }
                    } else {
                        useC = false;
                    }
                } else {
                    System.out.println("Geen ruimte meer");
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                calculateBestOption(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
            }
        }
    }

    public void runCe() {
        String perm = "";
        int productAmount = products.size();

        System.out.println("Er zijn " + productAmount + " producten");
        for (int i = 1; i <= productAmount; i++) {
            perm += i;
        }

        calculateBestOption(perm);

        System.out.print(maxSpaceLeft);
    }

}
