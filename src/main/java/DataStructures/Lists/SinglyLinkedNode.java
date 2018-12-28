package DataStructures.Lists;

import problems.linkedLists.Partition;

public class SinglyLinkedNode {
    private int value;
    private SinglyLinkedNode next;

    public SinglyLinkedNode(int value){
        this.value = value;
        this.next = null;
    }

    public SinglyLinkedNode(int[] values){
        if(values == null || values.length == 0){
            throw new IllegalArgumentException("Provided int array cannot be null or empty");
        }
        this.value = values[0];
        SinglyLinkedNode prev = this;
        for(int i=1; i< values.length; i++){
            prev.next = new SinglyLinkedNode(values[i]);
            prev = prev.next;
        }
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

    public boolean equals(Object obj){
        if(!(obj instanceof SinglyLinkedNode)){
            return false;
        }

        SinglyLinkedNode otherNode = (SinglyLinkedNode) obj;

        SinglyLinkedNode thisNode = this;

        while(thisNode != null){
            if(thisNode.getValue() != otherNode.getValue()){
                return false;
            } else{
                if((thisNode.hasNext() && !otherNode.hasNext() || (otherNode.hasNext() && !thisNode.hasNext()))){
                    return false;
                }
                thisNode = thisNode.getNext();
                otherNode= otherNode.getNext();
            }
        }
        return (otherNode == null);
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(this.value);
        SinglyLinkedNode curr = this.next;
        while(curr != null){
            builder.append("->").append(curr.getValue());
            curr = curr.next;
        }
        return builder.toString();
    }
}
