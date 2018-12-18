package DataStructures.Lists;

public class SinglyLinkedNode {
    private int value;
    private SinglyLinkedNode next;

    public SinglyLinkedNode(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public SinglyLinkedNode getNext() {
        return next;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setNext(SinglyLinkedNode next) {
        this.next = next;
    }

    public boolean hasNext(){
        return next != null;
    }
}
