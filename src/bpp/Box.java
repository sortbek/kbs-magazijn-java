/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpp;

/**
 *
 * @author Marjolein
 */
public class Box {
    private int idBox;
    private int size;
    private int coverd;
    private int idoreder;
    
      public Box(int idBox, int size, int coverd, int idoreder) {
        this.idBox = idBox;
        this.size = size;
        this.coverd = coverd;
        this.idoreder = idoreder;
    }
    

    public void setIdBox(int idBox) {
        this.idBox = idBox;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setCoverd(int coverd) {
        this.coverd = coverd;
    }

    public void setIdoreder(int idoreder) {
        this.idoreder = idoreder;
    }

    public int getIdBox() {
        return idBox;
    }

    public int getSize() {
        return size;
    }

    public int getCoverd() {
        return coverd;
    }

    public int getIdoreder() {
        return idoreder;
    }

  
}
