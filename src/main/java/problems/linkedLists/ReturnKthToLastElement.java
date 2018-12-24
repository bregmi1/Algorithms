package problems.linkedLists;

// Cracking the Code Interview Sixth Edition (Problem 2.2)
// Implement an algorithm to find the kth to last element of a singly linked list.

import DataStructures.Lists.SinglyLinkedNode;

public class ReturnKthToLastElement {

    // Runtime Complexity: O(n)
    // Space Complexity: O(1)
    public static int getKthToLastElement(SinglyLinkedNode head, int k){
        if(head == null || k < 0){
            throw new IllegalArgumentException("Given node cannot be null");
        }

        SinglyLinkedNode runner = head;
        while(runner != null && k > 0){
            runner = runner.getNext();
            k--;
        }

        if(runner == null  && k>0 ){
            throw new IndexOutOfBoundsException("Given index is out of bound");
        }

        SinglyLinkedNode current = head;

        while(runner != null){
            runner = runner.getNext();
            current = current.getNext();
        }

        return current.getValue();
    }

    public static void main(String[] args){
        SinglyLinkedNode node1 = new SinglyLinkedNode(new int[]{3,2,6,3,7,4,7,4,7});
        SinglyLinkedNode node2 = new SinglyLinkedNode(new int[]{4,3,5,6,3});
        SinglyLinkedNode node3 = new SinglyLinkedNode(6);

        if(
                getKthToLastElement(node1, 1) == 7 &&
                getKthToLastElement(node1, 3) == 7 &&
                getKthToLastElement(node3, 1) == 6 &&
                getKthToLastElement(node2, 4) == 3 &&
                getKthToLastElement(node1, 9) == 3
        ){
            System.out.println("Tests passed");
        } else{
            System.out.println("Tests failed");
        }
    }
}
