package bpp;

import java.util.ArrayList;

public class Product {
    
    private String name;
    private int idProduct;
    // private int size;
    
    public Product(String n, int id ){
    this.name = n;
    this.idProduct = id;
    }
    
    public String Getname(){
    return name;
    }
    
    public void Setname(String n){
        this.name = n;
    }
    
    public int GetidProduct(){
    return idProduct;
    }
    
    public void SetidProduct(int id){
        this.idProduct = id;
    }
    
    //public int Getsize(){
    //return size;
    //}
    
    //public void Setsize(int s){
    //this.size = s;
    //}
       
    
}
