package bpp;

public class Box extends BoxDepository{
    private int idBox;
    private int size;
    private int covered;
    private int idorder;
    private String status;
    
      public Box(int idBox, int size, int covered, int idorder, String status) {
        this.idBox = idBox;
        this.size = size;
        this.covered = covered;
        this.idorder = idorder;
        this.status = status;
    }
    

    public void setIdBox(int idBox) {
        this.idBox = idBox;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setCovered(int covered) {
        this.covered = covered;
    }

    void setIdorder(int idorder) {
        this.idorder = idorder;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdBox() {
        return idBox;
    }

    public int getSizeB() {
        return size;
    }

    public int getCovered() {
        return covered;
    }

    public int getIdorder() {
        return idorder;
    }
    
    public String getStatus() {
        return status;
    }
    
    public String toString(){
    return ("Box: "+idBox + "\nSize: "+ size + "\nArea covered: " + covered + "\nOrdernr: " +idorder + "\nStatus:" + status);
    }  
}
