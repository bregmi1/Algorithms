package problems.arraysAndStrings;

// Cracking the Code Interview Sixth Edition (Problem 1.4)
// Given a string, write a function to check if it is a permutation of a palindrom.
// A palindrome is a word or phrase that is the same forward and backwards.
// A permutation is a rearrangement of letters.
// The palindrome does not need to be limited to just dictionary words.

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {

    // Runtime Complexity: O(n)
    // Space Complexity: O(c), where c is the number of alphabets

    public static boolean palindromePermutation(String string){
        HashMap<Character, Integer> map = alphabetCount(string);
        boolean oddNumberFound = false;
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            if(entry.getValue() % 2 != 0){
                if(!oddNumberFound){
                    oddNumberFound = true;
                } else{
                    return false;
                }
            }
        }
        return true;
    }

    public static HashMap<Character, Integer> alphabetCount(String str){
        HashMap<Character, Integer> map = new HashMap<>();
        if(str == null || str.isEmpty()){
            return map;
        }

        str = str.toLowerCase();
        for(char c: str.toCharArray()){
            if(c >= 'a' && c <='z') {
                int count = map.containsKey(c) ? (map.get(c) + 1) : 1;
                map.put(c, count);
            }
        }
        return map;
    }

    public static void main(String[] args){
        String input1 = "Tact Coa";
        String input2 = "aabccd";
        String nullString = null;
        String emptyString = "";
        String singleCharString = "s";

        if(palindromePermutation(input1) &&
                palindromePermutation(nullString) &&
                palindromePermutation(emptyString) &&
                palindromePermutation(singleCharString) &&
                !palindromePermutation(input2)){
            System.out.println("Tests passed");
        } else{
            System.out.println("Tests failed");
        }
    }
}
