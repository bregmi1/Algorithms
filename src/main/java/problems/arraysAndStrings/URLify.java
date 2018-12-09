package problems.arraysAndStrings;

// Cracking the Code Interview Sixth Edition (Problem 1.3)
// Write a method to replace all spaces in a string with '%20'.
// You may assume that the string has sufficient space at the end to hold all the characters,
// and that you are given the true length of the string.
// Note: If implementing in Java, please use a character array so that you can perform this operation in place.

import java.util.Arrays;

public class URLify {

    // Solution by iterating forward
    // Runtime Complexity: O(n^2), where n is the length of the array and not the length of string
    // Space Complexity: O(1)

    public static char[] urlifyIterateForward(char[] arr, int len){
        for(int i=0; i<arr.length; i++){
            if(arr[i] == ' '){
                offset(i, arr);
                arr[i] = '%';
                arr[i+1] = '2';
                arr[i+2] = '0';
                i+= 2;
            }
        }
        return arr;
    }

    // Solution by iterating backward
    // Runtime Complexity: O(n), where n is the length of the array and not the length of string
    // Space Complexity: O(1)

    public static char[] urlifyIterateBackward(char[] arr, int len){
        int dstIndex = arr.length - 1;
        for(int srcIndex = len-1; srcIndex >=0; srcIndex--){
            if(arr[srcIndex] == ' '){
                arr[dstIndex] = '0';
                arr[dstIndex-1] = '2';
                arr[dstIndex-2] = '%';
                dstIndex -= 3;
            } else{
                arr[dstIndex] = arr[srcIndex];
                dstIndex--;
            }
        }
        return arr;
    }

    public static char[] offset(int index, char[] arr){
        for(int i = arr.length-3; i > index; i--){
            arr[i+2] = arr[i];
        }
        return arr;
    }
    public static void main(String[] args){
        char[] singleSpace1 = new char[3];
        char[] singleSpace2 = new char[3];
        singleSpace1[0] = ' ';
        singleSpace2[0] = ' ';
        char[] singleSpaceResult1 = {'%', '2', '0'};
        char[] singleSpaceResult2 = {'%', '2', '0'};
        char[] singleChar1 = {'a'};
        char[] singleChar2 = {'a'};
        char[] input1 = {'M','r',' ','J','o','h','n',' ','S','m','i','t','h',' ',' ',' ',' '};
        char[] input2 = {'M','r',' ','J','o','h','n',' ','S','m','i','t','h',' ',' ',' ',' '};
        char[] result1= {'M','r','%','2','0','J','o','h','n','%','2','0','S','m','i','t','h'};
        char[] result2= {'M','r','%','2','0','J','o','h','n','%','2','0','S','m','i','t','h'};

        if(Arrays.equals(urlifyIterateForward(singleSpace1, 1), singleSpaceResult1) &&
                Arrays.equals(urlifyIterateForward(singleChar1,1), singleChar1) &&
                Arrays.equals(urlifyIterateForward(input1, 13), result1) &&
                Arrays.equals(urlifyIterateBackward(singleSpace2, 1), singleSpaceResult2) &&
                Arrays.equals(urlifyIterateBackward(singleChar2, 1), singleChar2) &&
                Arrays.equals(urlifyIterateBackward(input2, 13), result2)){
            System.out.println("Tests passed");
        } else{
            System.out.println("Tests failed");
        }
    }
}
