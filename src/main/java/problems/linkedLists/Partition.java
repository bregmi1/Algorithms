package problems.linkedLists;

import DataStructures.Lists.SinglyLinkedNode;

// Cracking the Code Interview Sixth Edition (Problem 2.3)
// Write code to partition a linked list around a value x, such that all nodes less than x come
// before all the nodes greater than or equal to x.
// If x is contained withing the list, the values of x only need to be after the elements less than x (see below).
// EXAMPLE
// Input: 3->5->8->5->10->2->1 [partition = 5]
// Output: 3->1->2->10->5->5->8
public class Partition {

    // Run Complexity: O(n)
    // Space Complexity: O(1)
    public static SinglyLinkedNode partition(SinglyLinkedNode node, int partition){
        if(node == null || node.getNext() == null){
            return node;
        }

        SinglyLinkedNode head = node;
        SinglyLinkedNode tail = node;

        while(node != null){
            SinglyLinkedNode next = node.getNext();
            if(node.getValue() < partition){
                node.setNext(head);
                head = node;
            } else{
                tail.setNext(node);
                tail = node;
            }
            node = next;
        }
        tail.setNext(null);
        return head;
    }

    public static void main(String[] args){
        SinglyLinkedNode node1 = new SinglyLinkedNode(new int[] {3,2,5,7,8,3,6});
        SinglyLinkedNode result1 = new SinglyLinkedNode(new int[] {3,2,3,5,7,8,6});
        SinglyLinkedNode node2 = new SinglyLinkedNode(new int[] {3,5,8,5,10,1,2});
        SinglyLinkedNode result2 = new SinglyLinkedNode(new int[] {2,1,5,5,3,8,10});
        SinglyLinkedNode node3 = new SinglyLinkedNode(new int[]{8,4});
        SinglyLinkedNode result3 = new SinglyLinkedNode(new int[] {4, 8});


        if(
                partition(node1, 5).equals(result1) &&
                partition(node2, 7).equals(result2) &&
                partition(node3, 6).equals(result3)
        ){
            System.out.println("Tests passed");
        } else{
            System.out.println("Tests failed");
        }
    }
}
