package problems.arraysAndStrings;

// Cracking the Code Interview Sixth Edition (Problem 1.5)
// There are three types of edits that can be performed on strings: insert a character, remove a character, or replace a character.
// Given two strings, write a function to check if they are one edit (or zero edits) away.

public class OneAway {

    public static boolean oneAway(String s1, String s2){
        return oneAway(s1, s2, 0);
    }

    public static boolean oneAway(String s1, String s2, int diff){
        if(baseAcceptanceCriteria(s1, s2, diff)){
            return true;
        }
        if(baseRejectionCriteria(s1, s2, diff)){
            return false;
        }

        if(s1.charAt(0) == s2.charAt(0)){
            s1 = s1.substring(1);
            s2 = s2.substring(1);
        } else{
            diff++;
            if(s1.length() == s2.length()){
                s1 = s1.substring(1);
                s2 = s2.substring(1);
            } else if(s1.length() > s2.length()){
                s1 = s1.substring(1);
            } else{
                s2 = s2.substring(1);
            }
        }
        return oneAway(s1, s2, diff);
    }

    public static boolean baseAcceptanceCriteria(String s1, String s2, int diff){
        if(s1 == null && s2 == null){
            return true;
        } else if(s1 == null || s2 == null){
            return false;
        } else if((s1.isEmpty() && s2.isEmpty())){
            return true;
        }else if(diff == 0){
            return ((s1.length() == 1 && s2.isEmpty()) || (s2.length() == 1 && s1.isEmpty()));
        }
        return false;
    }

    public static boolean baseRejectionCriteria(String s1, String s2, int diff){
        if(s1 == null && s2 == null){
            return false;
        }
        if(s1 == null  || s2 == null){
            return true;
        }
        return ((diff + Math.abs(s1.length() - s2.length())) > 1);
    }

    public static void main(String[] args){
        String pale = "pale";
        String ple = "ple";
        String pales = "pales";
        String bale = "bale";
        String bake = "bake";

        if(oneAway(pale, ple) &&
                oneAway(pales, pale) &&
                oneAway(pale, bale) &&
                !oneAway(pale, bake)
        ){
            System.out.println("Tests passed");
        } else{
            System.out.println("Tests failed");
        }
    }
}
