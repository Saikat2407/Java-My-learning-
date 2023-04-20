package saikat.DLL;

public class Main {
    public static void main(String[] args) {
        DLL list = new DLL();

        list.insertFirst(78);
        list.insertFirst(34);
        list.insertFirst(12);
        list.insertFirst(34);
        list.insertFirst(100);

        list.display();
    }
}
