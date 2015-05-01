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
public class BestFit {
    
    private Depository depository;
    private BoxDepository boxd;
    private ArrayList<Product> producten;
    private ArrayList<Box> arrayBox;
    private Box b;
    private Product p;
    private MySQLbpp bpp = new MySQLbpp();

    public BestFit() {

    }

    public void setBoxDepository(BoxDepository b) {
        boxd = b;
        arrayBox = boxd.getList();
        int a = arrayBox.size();
    }

    public void setDepository(Depository b) {
        this.depository = b;
        producten = depository.getList();
    }

    public Depository getDepository() {
        return this.depository;
    }

    public void setProducten(ArrayList<Product> p) {
        this.producten = p;
    }


//    public void BF(int idorder){
//        int boxnr = 0;
//        int coverd = 0;
//        while(depository.GetSizeOrder()>20){
//            boxnr = bpp.NewBox(20, idorder);
//            int s = depository.GetBigProduct();
//            int pnr = bpp.GetProductWithSize(s);
//            coverd = 20-s;
//            bpp.SetBox(boxnr, pnr);
//            while (depository.GetSmallProduct(coverd)> depository.GetSmallestProduct(coverd)){
//                s = depository.GetSmallProduct(coverd);
//                pnr = bpp.GetProductWithSize(s);
//                
//                bpp.SetBox(boxnr, pnr);
//                System.out.println("test");
//            }
//            System.out.println("deze doos is vol");
//        
//        }
//        

        
    }
    
//    int i = GetSizeOrder();
//    int inhoudbox;
//    }
    
    // kiezen dozen en vullen dozen
//    while (i>20){
//        inhoudbox = 20;
//        // maak een doos van 20 groot aan
//        System.out.println("doos gemaakt van 20");
//        System.out.println(i);
//        GetBigProduct();
//        System.out.println(GetBigProduct());
//        i = i-GetBigProduct();
//        //product met die maat uit de lijst halen en in de box zetten
//        inhoudbox = inhoudbox - GetBigProduct();
//        while (GetSmallProduct(inhoudbox) != 0){
//        while (inhoudbox >= GetSmallProduct(inhoudbox)){
//         System.out.println("product is "+GetSmallProduct(inhoudbox)+ " groot");
//         //product met die maat uit de lijst halen en in de box zetten
//         i = i-GetSmallProduct(inhoudbox);
//         System.out.println("er is nog "+ i + "over ");
//        }}
//    }
//    while (i>10){
//        inhoudbox = 10;
//      // maak een doos van 10 groot aan
//        i = i-10;
//        System.out.println("doos gemaakt van 10");
//        System.out.println(i);
//        GetBigProduct();
//        System.out.println(GetBigProduct());
//         i = i-GetBigProduct();
//        //product met die maat uit de lijst halen en in de box zetten
//        inhoudbox = inhoudbox - GetBigProduct();
//        while (GetSmallProduct(inhoudbox) != 0){
//        while (inhoudbox >= GetSmallProduct(inhoudbox)){
//         System.out.println("product is "+GetSmallProduct(inhoudbox)+ " groot");
//         //product met die maat uit de lijst halen en in de box zetten
//         i = i-GetSmallProduct(inhoudbox);
//         System.out.println("er is nog "+ i + "over ");
//        }}
//    }
//    while (i>1){
//        inhoudbox = 5;
//      // maak een doos van 5 groot aan
//        i = i-5;
//        System.out.println("doos gemaakt van 5");
//        System.out.println(i);
//         i = i-GetBigProduct();
//        //product met die maat uit de lijst halen en in de box zetten
//        inhoudbox = inhoudbox - GetBigProduct();
//        while (GetSmallProduct(inhoudbox) != 0){
//        while (inhoudbox >= GetSmallProduct(inhoudbox)){
//         System.out.println("product is "+GetSmallProduct(inhoudbox)+ " groot");
//         //product met die maat uit de lijst halen en in de box zetten
//         i = i-GetSmallProduct(inhoudbox);
//         System.out.println("er is nog "+ i + "over ");
//        }}
//    }
//    
//    }
    
    

