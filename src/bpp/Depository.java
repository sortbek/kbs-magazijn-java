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
public class Depository extends BPPSimulatorGUI {

    private ArrayList<Product> products;
    private Product p;

    public Depository() {
        products = new ArrayList<>();
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public int ShowArrayList() {
        //Show al Products in the Depository
        int size = 0;
        while (products.size() > size) {

            p = products.get(size);
            System.out.println(products.get(size));
            size++;
        }
        return size;
    }

    public int GetSizeArraylist() {
        //Get Size of the ArrayList
        return products.size() + 1;
    }

    public int GetBigProduct() {
        // Get biggest Product out of the arrayList
        int j = 0;
        int sizeb = 0;
        while (products.size() > j) {
            p = products.get(j);
            if (p.GetBox() == 0) {
                if (sizeb < p.Getsize()) {
                    sizeb = p.Getsize();
                }
            }
            j++;
        }
        System.out.println("grooste product is : " + sizeb);
        return sizeb;
    }

    public int GetTotalSizeOrder() {
        // Get the total size of the order who isn't already in a box.
        int j = 0;
        int sizet = 0;
        while (products.size() > j) {
            p = products.get(j);
            sizet = sizet + p.Getsize();
            j++;
        }
        return sizet;
    }

    public int GetSmallProduct(int s) {
        // Get Biggest Product that fit into a space of s
        int j = 0;
        int sizeb = 0;
        int nr = 0;
        while (products.size() > j) {
            p = products.get(j);
            if (p.GetBox() == 0) {
                if (s >= p.Getsize()) {

                    if (sizeb < p.Getsize()) {
                        sizeb = p.Getsize();
                        nr = j;
                    }
                }
            }
            j++;
        }
        return sizeb;
    }

    public int GetProductWithSize(int size) {
        // Get nr of the arrayList from product with size
        int j = 0;
        int ProductId;
        int nrProduct = 0;
        while (products.size() > j) {
            p = products.get(j);
            if (p.GetBox() == 0) {
                if (size == p.Getsize()) {
                    nrProduct = j;
                    ProductId = p.GetidProduct();
                    System.out.println("productnr " + ProductId);
                }
            }
            j++;
        }
        return nrProduct;
    }

    public ArrayList<Product> getList() {
        return products;
    }
}
