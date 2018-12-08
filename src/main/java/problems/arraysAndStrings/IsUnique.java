package problems.arraysAndStrings;

//Problem taken from Cracking the Code Interview Sixth Edition (Problem 1.1)
//Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?

import java.util.HashMap;


//Assumptions: If the string is null or empty, it is considered to be made of unique characters
public class IsUnique {

    // Solution using a map
    // Runtime complexity: O(n)
    // Space Complexity: O(n)

    public static boolean isUniqueUsingMap(String str){
        if(str == null) {
            return true;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: str.toCharArray()){
            if(map.containsKey(c)){
                return false;
            } else{
                map.put(c, 1);
            }
        }
        return true;
    }



    // Solution without using additional data structures
    // Runtime Complexity: O(n^2)
    // Space Complexity: O(1)

    public static boolean isUnique(String str){
        if(str == null) {
            return true;
        }
        int len = str.length();

        for(int i=0; i < len; i++){
            char current = str.charAt(i);

            for(int j = i+1; j < len; j++){
                if(current == str.charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        String nullString = null;
        String emptyString = "";
        String singleCharString = "a";
        String uniqueCharString = "abcdefghijkl";
        String nonUniqueCharString = "abcdefghija";

        if(isUnique(nullString) &&
                isUnique(emptyString) &&
                isUnique(singleCharString) &&
                isUnique(uniqueCharString) &&
                !isUnique(nonUniqueCharString)){
            System.out.println("isUnique(String string) method passed the tests");
        } else{
            System.out.println("isUnique(String string) method did not pass the tests");
        }

        if(isUniqueUsingMap(nullString) &&
                isUniqueUsingMap(emptyString) &&
                isUniqueUsingMap(singleCharString) &&
                isUniqueUsingMap(uniqueCharString) &&
                !isUniqueUsingMap(nonUniqueCharString)){
            System.out.println("isUniqueUsingMap(String string) method passed the tests");
        } else{
            System.out.println("isUniqueUsingMap(String string) method did not pass the tests");
        }
    }
}
