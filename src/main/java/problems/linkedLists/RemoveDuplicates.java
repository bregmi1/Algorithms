package problems.linkedLists;

// Cracking the Code Interview Sixth Edition (Problem 2.1)
// Write code to remove duplicates from an unsorted linked list.
// How would you solve this problem if a temporary buffer is not allowed?

import DataStructures.Lists.SinglyLinkedNode;
import java.util.HashMap;

public class RemoveDuplicates {

    // Solution using buffer
    // Runtime Complexity: O(n)
    // Space Complexity: O(n)
    public static SinglyLinkedNode removeDuplicates(SinglyLinkedNode head){
        if(head == null || head.getNext() == null){
            return head;
        }

        SinglyLinkedNode prev = head;
        SinglyLinkedNode current = head.getNext();
        HashMap<Integer, Boolean> visitedValue = new HashMap<>();
        visitedValue.put(head.getValue(), true);

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

    // Solution without using buffer
    // Runtime Complexity: O(n^2)
    // Space Comlexity: O(1)
    public static SinglyLinkedNode removeDuplicatesNoBuffer(SinglyLinkedNode head){
        if(head == null || head.getNext() == null){
            return head;
        }


        for(SinglyLinkedNode index = head; index != null && index.getNext() != null; index = index.getNext()){
            SinglyLinkedNode prev = index;
            SinglyLinkedNode current = index.getNext();


            while(current != null){
                if(current.getValue() == index.getValue()){
                    prev.setNext(current.getNext());
                    current = current.getNext();
                } else{
                    prev = current;
                    current = current.getNext();
                }
            }
        }

        return head;

    }


    public static void main(String[] args){
        SinglyLinkedNode test1 = new SinglyLinkedNode(new int[]{3,5,6,3,6,3,5,5,5,7});
        SinglyLinkedNode test11 = new SinglyLinkedNode(new int[]{3,5,6,3,6,3,5,5,5,7});
        SinglyLinkedNode result1 = new SinglyLinkedNode(new int[]{3,5,6,7});
        SinglyLinkedNode test2 = new SinglyLinkedNode(new int[] {4,4});
        SinglyLinkedNode test22 = new SinglyLinkedNode(new int[] {4,4});
        SinglyLinkedNode result2 = new SinglyLinkedNode(new int[]{4});
        SinglyLinkedNode test3 = new SinglyLinkedNode(new int[]{4,3,5,7,1});
        SinglyLinkedNode test33 = new SinglyLinkedNode(new int[]{4,3,5,7,1});
        SinglyLinkedNode result3 = new SinglyLinkedNode(new int[]{4,3,5,7,1});


        if(
                result1.equals(removeDuplicates(test1)) &&
                result2.equals(removeDuplicates(test2)) &&
                result3.equals(removeDuplicates(test3)) &&
                result1.equals(removeDuplicatesNoBuffer(test11)) &&
                result2.equals(removeDuplicatesNoBuffer(test22)) &&
                result3.equals(removeDuplicatesNoBuffer(test33))
        ){
            System.out.println("Tests passed");
        } else{
            System.out.println("Tests failed");
        }
    }
}
