package bpp;

import java.util.ArrayList;

public class CompleteEnumeration {

    private Depository depository;
    private BoxDepository boxd;
    private ArrayList<Product> products;
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

    public static void possibleCombinations(int maxLength, ArrayList products, String curr) {

        // If the current string has reached it's maximum length
        if (curr.length() == maxLength) {
            System.out.println(curr);

            // Else add each letter from the alphabet to new strings and process these new strings again
        } else {
            for (int i = 0; i < products.size(); i++) {
                String oldCurr = curr;
                curr += products.get(i);
                possibleCombinations(maxLength, products, curr);
                curr = oldCurr;
            }
        }
    }

public void runCe() {
        int productAmount = products.size();
        
        
        
    }


}
