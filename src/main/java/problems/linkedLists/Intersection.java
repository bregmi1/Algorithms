package problems.linkedLists;

// Cracking the Code Interview Sixth Edition (Problem 2.7)
// Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting node.
// Note that the intersection is defined based on reference, not value.
// That is, if the kth node of the first linked list is the exact same node (by reference) as the jth node of the second
// linked list, then they are intersecting.

import DataStructures.Lists.SinglyLinkedNode;


public class Intersection {

    // Runtime Complexity: O(m+n), where m and n are the length of the two linked lists
    // Space Complexity: O(1)
    public static boolean checkIntersection(SinglyLinkedNode node1, SinglyLinkedNode node2){
        SinglyLinkedNode last1 = null;
        while(node1 != null){
            last1 = node1;
            node1  = node1.getNext();
        }

        SinglyLinkedNode last2 = null;
        while(node2 != null) {
            last2 = node2;
            node2 = node2.getNext();
        }

        return last1 == last2;
    }

    public static void main(String[] args){
        SinglyLinkedNode node1 = new SinglyLinkedNode(1);
        SinglyLinkedNode node2 = new SinglyLinkedNode(2);
        SinglyLinkedNode node3 = new SinglyLinkedNode(3);
        SinglyLinkedNode node4 = new SinglyLinkedNode(4);
        SinglyLinkedNode node5 = new SinglyLinkedNode(5);
        SinglyLinkedNode node6 = new SinglyLinkedNode(6);
        SinglyLinkedNode node7 = new SinglyLinkedNode(7);
        SinglyLinkedNode node8 = new SinglyLinkedNode(8);
        SinglyLinkedNode node9 = new SinglyLinkedNode(9);

        node5.setNext(null);
        node4.setNext(node5);
        node3.setNext(node4);
        node2.setNext(node3);
        node1.setNext(node2);

        node6.setNext(node7);
        node7.setNext(node3);

        node9.setNext(null);
        node8.setNext(node9);

        if(checkIntersection(node1, node6) && !checkIntersection(node1,node8)){
            System.out.println("Tests Passed");
        } else{
            System.out.println("Tests Failed");
        }

    }
}
