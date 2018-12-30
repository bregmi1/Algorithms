package problems.linkedLists;

// Cracking the Code Interview Sixth Edition (Problem 2.6)
// Implement a function to check if a linked list is a palindrome.


import DataStructures.Lists.SinglyLinkedNode;

public class Palindrome {

    // Runtime Complexity: O(n)
    // Space Complexity: O(n)
    public static boolean checkPalindrome(SinglyLinkedNode head){
        if(head == null || head.getNext() == null){
            return true;
        }

        SinglyLinkedNode reversed =  reverseList(head);
        return head.equals(reversed);
    }

    public static SinglyLinkedNode reverseList(SinglyLinkedNode node){
        if(node == null || node.getNext() == null){
            return node;
        }
        SinglyLinkedNode current = null;
        while(node != null){
            SinglyLinkedNode temp = new SinglyLinkedNode(node.getValue());
            temp.setNext(current);
            current = temp;
            node = node.getNext();
        }
        return current;
    }


    public static void main(String[] args){
        SinglyLinkedNode palindrome1 = new SinglyLinkedNode(new int[] {1,2,3,4,5,4,3,2,1});
        SinglyLinkedNode palindrome2 = new SinglyLinkedNode(new int[] {5,4,5});
        SinglyLinkedNode palindrome3 = new SinglyLinkedNode(3);
        SinglyLinkedNode node1 = new SinglyLinkedNode(new int[] {4,3,7,6,2,4});
        SinglyLinkedNode node2 = new SinglyLinkedNode(new int[] {3,6});
        SinglyLinkedNode node3 = null;

        if(
                checkPalindrome(palindrome1) &&
                checkPalindrome(palindrome2) &&
                checkPalindrome(palindrome3) &&
                !checkPalindrome(node1) &&
                !checkPalindrome(node2) &&
                checkPalindrome(node3)
        ) {
            System.out.println("Tests passed");
        } else{
            System.out.println("Tests failed");
        }
    }
}
