package problems.arraysAndStrings;

// Problem taken from Cracking the Code Interview Sixth Edition (Problem 1.2)
// Given two strings, write a method to decide if one is a permutation of the other

import java.util.HashMap;

public class CheckPermutation {

    // Runtime Complexity: O(a) where a is the greater value of the two string lengths
    // Space Complexity: O(c) where c is the number of characters (For english alphabets it is 26)
    public static boolean checkPermutation(String str1, String str2){
        HashMap<Character, Integer> map1 = characterCount(str1);
        HashMap<Character, Integer> map2 = characterCount(str2);
        return (map1.equals(map2));
    }


    // Runtime Complexity: O(n)
    // Space Complexity: O(c) where c is the number of characters (For english alphabets it is 26)
    public static HashMap<Character, Integer> characterCount(String string){
        HashMap<Character, Integer> map = new HashMap<>();

        if(string == null){
            return map;
        }
        int count = 0;
        for(char c: string.toCharArray()){
            count = map.containsKey(c) ? (map.get(c) + 1) : 1;
            map.put(c, count);
        }
        return map;
    }

    public static void main(String[] args){
        String str1 = "dtknfthjukkk";
        String str2 = "ftukdthjkkkn";
        String str3 = "aabcdee";
        String nullString =  null;
        String emptyString = "";
        String singleCharString = "x";

        if(checkPermutation(str1, str2) &&
                checkPermutation(nullString, nullString) &&
                checkPermutation(emptyString, emptyString) &&
                checkPermutation(singleCharString, singleCharString) &&
                !checkPermutation(str1, str3) &&
                !checkPermutation(nullString, str2) &&
                !checkPermutation(singleCharString, str3) &&
                !checkPermutation(emptyString, str3)){
            System.out.println("Tests passed");
        } else{
            System.out.println("Tests failed");
        }
    }
}
