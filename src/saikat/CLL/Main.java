package saikat.CLL;

public class Main {
    public static void main(String[] args) {
        CLL list = new CLL();
        list.insert(12);
        list.insert(1);
        list.insert(20);
        list.insert(54);
        list.insert(100);

        list.display();

        list.delete(12);

        list.display();
    }

}
