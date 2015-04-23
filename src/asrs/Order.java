/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asrs;

import java.util.ArrayList;
import java.sql.Date;

/**
 *
 * @author jeffreywienen
 */
public class Order {
    private Customer c;
    private int Ordernr;
    private Date date;
    public enum State{
    QUEUED,IN_PROGRESS,FINISHED
    }
    private State state;
    
    ArrayList<Product> products = new ArrayList<Product>();    
    
    public Order(int Ordernr, Customer c){
        this.state = state.QUEUED;
        this.Ordernr = Ordernr;
        this.c = c;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        if(this.state != state){
            this.updateState(state);
        }
        this.state = state;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public int getOrdernr() {
        return Ordernr;
    }
    
    public ArrayList<Product> getProducts() {
        return products;
    }
     
    public void addProduct(Product nr){
        products.add(nr);
    }   

    public Customer getC() {
        return c;
    }
    
    public void updateState(State state){
        MySQL sql = new MySQL();
        sql.updateOrderState(this, state);
    }
    
    public void addToQueue(){
        MySQL sql = new MySQL();
        sql.insertOrder(this);
    }
}
