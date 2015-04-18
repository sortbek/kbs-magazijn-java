/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asrs;

import java.util.ArrayList;

/**
 *
 * @author jeffreywienen
 */
public class Order {
    private Customer c;
    private int Ordernr;
    private String Customer;
    private int progress;
    
    ArrayList<Integer> products = new ArrayList<Integer>();    
    
    public Order(int Ordernr, Customer c){
        this.Ordernr = Ordernr;
        this.c = c;
    }
    
    public int getOrdernr() {
        return Ordernr;
    }
    
    public ArrayList<Integer> getProducts() {
        return products;
    }
     
    public void addProduct(int nr){
        products.add(nr);
    }   

    public Customer getC() {
        return c;
    }
    
    
    public void addToQueue(){
        MySQL sql = new MySQL();
        sql.insertOrder(this);
    }
}
