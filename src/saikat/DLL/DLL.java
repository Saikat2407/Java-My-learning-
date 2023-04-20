package saikat.DLL;

import saikat.SL.LL;

public class DLL {
    private class Node{
        int value;
        Node next;
        Node prev;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node head;
    public void insertFirst(int value){
        Node node = new Node(value);
        node.next = head;
        node.prev = null;
        if (head != null){
            head.prev = node;
        }
        head = node;
    }

    public void insertlast(int value){
        Node node = new Node(value);
        Node last = head;

        node.next = null;

        if (head == null){
            node.prev = null;
            head = node;
            return;
        }

        while (last.next != null){
            last = last.next;
        }
        last.next = node;
        node.prev = last;
    }

    public Node ReturnTheNode(int value) {
        Node node = head;
        while (node != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public void InsertAtGivenIndex(int AfterNode, int val){

        Node p = ReturnTheNode(AfterNode);

        if(p == null){
            System.out.println("Doesn't exist");
            return;
        }
        Node node = new Node(val);
        node.next = p.next;
        p.next = node;
        node.prev = p;
        if (node.next != null){
            node.next.prev = node;
        }
    }

    public void display(){
        Node node = head;
        while(node != null){
            System.out.print(node.value + " -> ");
            node = node.next;
        }
        System.out.println("END OF LIST");
    }

    public void displayREV(){
        Node node = head;
        Node last = null;
        while(node != null){
            System.out.print(node.value + " -> ");
            last = node;
            node = last.next;
        }
        System.out.println("END");

        System.out.println("Print in Reverse");
        while (last != null){
            System.out.print(last.value + " -> ");
            last = last.prev;
        }
        System.out.println("START");
    }

}
