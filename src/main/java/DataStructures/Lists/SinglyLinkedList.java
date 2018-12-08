package DataStructures.Lists;

// A simple integer based SinglyLinkedList

public class SinglyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public SinglyLinkedList(){
        head = tail = null;
        size = 0;
    }

    public SinglyLinkedList(int value){
        head = new Node(value);
        tail = head;
        size = 1;
    }

    public boolean add(int item){
        if(head == null){
            head = new Node(item);
            tail = head;
        } else{
            Node temp = new Node(item);
            tail.setNext(temp);
            tail = temp;
        }
        size++;
        return true;
    }

    public void clear(){
        head = tail = null;
        size = 0;
    }

    public boolean contains(int value){
        Node temp = head;
        while(temp != null){
            if(temp.getValue() == value){
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

    public int get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index: " + index + " is out of bound");
        }

        Node returnValue = head;
        while(index > 0){
            returnValue = returnValue.getNext();
            index--;
        }
        return returnValue.getValue();
    }

    public int remove(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index: " + index + " is out of bound");
        }
        int returnValue = 0;

        if(index == 0){
            returnValue = head.getValue();
            head = head.getNext();
        } else{
            Node prev = head;
            Node current = head.getNext();

            while(index > 1){
                prev = current;
                current = current.getNext();
                index--;
            }
            returnValue = current.getValue();
            prev.setNext(current.getNext());
        }
        size--;
        return returnValue;
    }

    public int getSize(){
        return this.size;
    }

    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public boolean hasNext(){
            return next != null;
        }
    }
}
