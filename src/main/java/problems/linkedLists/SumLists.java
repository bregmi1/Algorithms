package problems.linkedLists;

// Cracking the Code Interview Sixth Edition (Problem 2.5)
// You have two numbers represented by a linked list, where each node contains a single digit.
// The digits are stored in reverse order, such that the 1's digit is at the head of the list.
// Write a function that adds the two numbers and returns the sum as a linked list.
// EXAMPLE
// Input: (7->1->6) + (5->9->2). That is, 617 + 295.
// Output: 2->1->9. That is, 912

import DataStructures.Lists.SinglyLinkedNode;

public class SumLists {

    // RuntimeComplexity: O(m), where m is the length of the longer list
    // SpaceComplexity: O(m)
    public static SinglyLinkedNode sumList (SinglyLinkedNode list1, SinglyLinkedNode list2){
        if(list1 == null && list2 == null){
            return null;
        } else if(list1 == null || list2 == null){
            return  (list1 == null ? list2 : list1);
        }

        SinglyLinkedNode head = null;
        SinglyLinkedNode curr = null;
        SinglyLinkedNode temp = null;
        int carryOver = 0;
        int sum = 0;

        while(list1 != null && list2 != null){
            sum = carryOver + list1.getValue() + list2.getValue();
            carryOver = sum/10;
            temp = new SinglyLinkedNode(sum%10);

            if(head == null) {
                head = temp;
                curr = temp;
            } else{
                curr.setNext(temp);
                curr = curr.getNext();
            }
            list1 = list1.getNext();
            list2 = list2.getNext();
        }

        SinglyLinkedNode nonNullList = list1 == null ? list2 : list1;

        while(nonNullList != null){
            sum = carryOver + nonNullList.getValue();
            carryOver = sum/10;
            temp = new SinglyLinkedNode(sum%10);
            curr.setNext(temp);
            curr = curr.getNext();
            nonNullList = nonNullList.getNext();
        }

        if(carryOver > 0){
            curr.setNext(new SinglyLinkedNode(carryOver));
        }
        return head;
    }

    public static void main(String[] args){
        SinglyLinkedNode node11 = new SinglyLinkedNode(new int[] {7,1,6});
        SinglyLinkedNode node12 = new SinglyLinkedNode(new int[] {5, 9,2});
        SinglyLinkedNode result1 = new SinglyLinkedNode(new int[] {2,1,9});

        SinglyLinkedNode node21 = new SinglyLinkedNode(new int[]{9,9,9});
        SinglyLinkedNode node22 = new SinglyLinkedNode(new int[]{1});
        SinglyLinkedNode result2 = new SinglyLinkedNode(new int[]{0,0,0,1});

        SinglyLinkedNode node31 = new SinglyLinkedNode(new int[]{7});
        SinglyLinkedNode node32 = new SinglyLinkedNode(new int[]{5,9,9});
        SinglyLinkedNode result3 = new SinglyLinkedNode(new int[]{2,0,0,1});

        SinglyLinkedNode node41 = new SinglyLinkedNode(new int[] {3,5,2});
        SinglyLinkedNode node42 = null;
        SinglyLinkedNode result4 = new SinglyLinkedNode(new int[]{3,5,2});

        if(
                sumList(node11, node12).equals(result1) &&
                sumList(node21, node22).equals(result2) &&
                sumList(node31, node32).equals(result3) &&
                sumList(node41, node42).equals(result4) &&
                sumList(node42, node41).equals(result4) &&
                sumList(node42, null) == null
        ){
            System.out.println("Tests passed");
        } else{
            System.out.println("Tests failed");
        }
    }
}
