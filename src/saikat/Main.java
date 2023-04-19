package saikat;

public class Main {
    public static void main(String[] args) {
        LL list = new LL();
        list.insertFirst(7);
        list.insertFirst(9);
        list.insertFirst(8);
        list.insertFirst(6);
        list.insertLast(69);
        list.insert(12,3);
        list.display();
//        System.out.println(list.DeletefirstElement());
//        System.out.println(list.DeletelastElement());
//        System.out.println(list.delete(3));
        System.out.println(list.returntheNode(12));
        list.display();

    }
}
