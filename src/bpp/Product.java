package bpp;

public class Product extends Depository {

    private String name;
    private int idProduct;
    private int box;
    private int size;

    public Product(String n, int id, int s) {
        this.name = n;
        this.idProduct = id;
        this.size = s;
    }
    
    public String Getname() {
        return name;
    }

    public int GetidProduct() {
        return idProduct;
    }

    public int Getsize() {
        return size;
    }

    public int GetBox() {
        return box;
    }

    public void SetBox(int s) {
        this.box = s;
    }

    public String toString() {
        return ("Product name: " + name + "\nID: " + idProduct + "\nBox ID:  " + box + "\nSize: " + size);
    }

}
