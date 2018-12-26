package problems.linkedLists;

// Cracking the Code Interview Sixth Edition (Problem 2.3)
// Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node.
// Example
// Input: the node c from the linked list a->b->c->d->e
// Result: nothing is returned, but the new linked list looks like a->b->d->e


import DataStructures.Lists.SinglyLinkedNode;

public class DeleteMiddleNode {

    // Runtime Complexity: O(n/2)
    // Space Complexity: O(1)
    public static boolean deleteMiddleNode(SinglyLinkedNode middleNode){
        if(middleNode == null || middleNode.getNext() == null){
             return false;
        }

        SinglyLinkedNode next = middleNode.getNext();
        SinglyLinkedNode current = middleNode;

        while(next.getNext() != null){
            current.setValue(next.getValue());
            current = next;
            next = next.getNext();

        }
        current.setValue(next.getValue());
        current.setNext(null);
        return true;
    }

    public static SinglyLinkedNode getMiddleNode(SinglyLinkedNode head){
        if(head == null || head.getNext() == null){
            return head;
        }
        SinglyLinkedNode current = head;
        SinglyLinkedNode runner = head;
        while(runner.getNext() != null && runner.getNext().getNext() != null){
            current = current.getNext();
            runner = runner.getNext().getNext();
        }
        return current;
    }
    public static void main(String[] args){
        SinglyLinkedNode list1 = new SinglyLinkedNode(new int[]{2,3,5,3,5,6,7});
        SinglyLinkedNode result1 = new SinglyLinkedNode(new int[]{2,3,5,5,6,7});
        SinglyLinkedNode list2 = new SinglyLinkedNode(new int[]{4,3,5});
        SinglyLinkedNode result2 = new SinglyLinkedNode(new int[]{4, 5});
        SinglyLinkedNode list3 = new SinglyLinkedNode(4);
        SinglyLinkedNode result3 = new SinglyLinkedNode(4);


        deleteMiddleNode(getMiddleNode(list1));
        deleteMiddleNode(getMiddleNode(list2));
        deleteMiddleNode(getMiddleNode(list3));

        if(list1.equals(result1) && list2.equals(result2) && list3.equals(result3)){
            System.out.println("Tests passed");
        } else{
            System.out.println("Tests failed");
        }

    }
}
