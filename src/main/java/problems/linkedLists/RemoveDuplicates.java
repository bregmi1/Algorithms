package problems.linkedLists;

import DataStructures.Lists.SinglyLinkedNode;

import java.util.HashMap;

public class RemoveDuplicates {

    public SinglyLinkedNode removeDuplicates(SinglyLinkedNode head){
        if(head == null || head.getNext() == null){
            return head;
        }

        SinglyLinkedNode prev = head;
        SinglyLinkedNode current = head.getNext();
        HashMap<Integer, Boolean> visitedValue = new HashMap<>();

        while(current != null){
            if(visitedValue.containsKey(current.getValue())){
                prev.setNext(current.getNext());
                current = current.getNext();
            } else{
                visitedValue.put(current.getValue(), true);
                prev = current;
                current = current.getNext();
            }
        }

        return head;
    }
}
