/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asrs;

/**
 *
 * @author jeffreywienen
 */
public class Order {
    private int Ordernr;
    private String Customer;
    
    public Order(int Ordernr, String Customer){
        this.Ordernr = Ordernr;
        this.Customer = Customer;
    }
    
    public int getOrdernr() {
        return Ordernr;
    }

    public String getCustomer() {
        return Customer;
    }    
    
    public void AddProduct(){
        
    }  
    
    
}
