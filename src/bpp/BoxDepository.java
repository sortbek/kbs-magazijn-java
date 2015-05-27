package bpp;

import java.util.ArrayList;

public class BoxDepository extends BPPSimulatorGUI {

    private ArrayList<Box> box;
    private int j = 0;
    private Box b;

    public BoxDepository() {
        box = new ArrayList<>();
    }

    public void addBox(Box b) {
        box.add(b);
    }

    public void ShowArrayList() {
        while (box.size() > j) {

            b = box.get(j);
            System.out.println(box.get(j));
            System.out.println("**********************************");
            j++;
        }

    }

    public int GetSizeArraylist() {
        return box.size() + 1;
    }

    public int GettotalSize() {
        int size = 0;
        while (box.size() > j) {

            b = box.get(j);
            size = size + b.getSizeB();
            j++;
        }
        return size;
    }

    public ArrayList<Box> getList() {
        return box;
    }
}
