package saikat.SL;

public class LL {
    public Node head;
    public Node tail;
    public int size;

    public LL() {
        this.size = 0;
    }


    public class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;

        if(tail == null){
            tail=head;
        }
        size+=1;
    }
    public void insertLast(int val) {
        if (tail == null) {
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insert(int val, int index){
        if (index == 0){
            insertFirst(val);
            return;
        }
        if(index == size){
            insertLast(val);
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(val, temp.next);
        temp.next = node;
        size++;
    }

    //insert using recursion

    public void insertRec(int value, int index){
        head = insertRec(value,index,head);
    }

    private Node insertRec(int value, int index, Node node){
        if(index == 0){
            Node temp = new Node(value, node);
            size++;
            return temp;
        }
        node.next = insertRec(value,index-1,node.next);
        return node;
    }

    // delete the first element form the linked-list
    public int DeletefirstElement(){
        int Head = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return Head;
    }

    public int DeletelastElement(){
        if(size <= 1){
            DeletefirstElement();
        }
        Node secondlast = get(size-2);
        int Tail = tail.value;
        tail = secondlast;
        tail.next = null;
        size--;

        return Tail;
    }
    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public int delete(int index) {
        if (index == 0) {
            return DeletefirstElement();
        }
        if (index == size - 1) {
            return DeletelastElement();
        }

        Node prev = get(index-1);
        int prevVal = prev.next.value;

        prev.next = prev.next.next;
        size--;
        return prevVal;
    }

    //LEETCODE QUESTION
    // https://leetcode.com/problems/remove-duplicates-from-sorted-list

    public void duplicate(){
        Node node = head;

        while (node.next != null){
            if(node.value == node.next.value){
                node.next = node.next.next;
                size--;
            }else {
                node = node.next;
            }
        }
        tail = node;
        tail.next = null;
    }

    // https://leetcode.com/problems/merge-two-sorted-lists/submissions/

    public static LL merge(LL first, LL second){
        Node f = first.head;
        Node s = second.head;

        LL ans = new LL();

        while (f != null && s != null){
            if(f.value < s.value){
                ans.insertLast(f.value);
                f = f.next;
            } else {
                ans.insertLast(s.value);
                s = s.next;
            }
        }
        while (f != null) {
            ans.insertLast(f.value);
            f = f.next;
        }

        while (s != null) {
            ans.insertLast(s.value);
            s = s.next;
        }

        return ans;
    }

    public Node returntheNode(int value){
        Node node = head;
        while (node != null){
            if (node.value == value){
                return node;
            }
        }
        return null;
    }
    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END OF LIST");
    }
}

