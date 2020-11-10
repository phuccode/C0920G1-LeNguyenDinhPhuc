package _10_danh_sach_DSA.bai_tap.thu_vien_linkedlist;

public class MyLinkedList<E> {
    public class Node{
        private Node next;
        private Object data;
        public Node(Object data){
            this.data = data;
        }


        public Object getData() {
            return data;
        }
    }
    Node head;
    int numNodes = 0;

    public MyLinkedList(){
    }

    public void add(int index , E element){
        Node newNode = new Node(element);
        Node jump = head;

        for(int i = 0; i < numNodes - 1; i++){
            jump = jump.next;
        }
        jump.next = newNode;
        this.numNodes++;
    }

    public void displayList() {

        Node jump = head;

        while (jump != null) {
            System.out.println(jump.data);
            jump = jump.next;
        }
    }
}
