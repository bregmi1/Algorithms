package problems.arraysAndStrings;


// Cracking the Code Interview Sixth Edition (Problem 1.7)
// Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees.
// Can you do this in place?

public class RotateMatrix {


    // Runtime Complexity: O(n^2)
    // Space Complexity: O(1)
    private static int[][] rotateMatrix(int[][] arr){
        if(arr == null || arr.length == 0){
            return arr;
        }
        int len = arr.length;
        if(arr[0].length != len){
            throw new IllegalArgumentException("Given array is not square matrix");
        }

        for(int layer = 0; layer < len/2; layer++){
            int first = layer;
            int last = len-1-layer;
            int diff = last - first;
            for(int offset = 0; offset < diff; offset++){
                int temp = arr[first][first+offset];
                arr[first][first+offset] = arr[last-offset][first];
                arr[last-offset][first] = arr[last][last-offset];
                arr[last][last-offset] = arr[first+offset][last];
                arr[first+offset][last] = temp;
            }
        }
        return arr;
    }


    private static boolean equals(int[][] arr1, int[][] arr2){
        if(arr1 == null && arr2 == null){
            return true;
        } else if(arr1 == null || arr2 == null){
            return false;
        }else if(arr1.length != arr1[0].length || arr2.length != arr2[0].length){
            throw new IllegalArgumentException("One or more 2D array supplied is not square matrix");
        } else if(arr1.length != arr2.length){
            return false;
        }

        for(int i=0; i< arr1.length; i++){
            for(int j=0; j< arr1.length; j++){
                if(arr1[i][j] != arr2[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        int [][] arr = new int[4][4];
        int [][] result = new int[4][4];

        for(int i=0;i < arr.length; i++){
            for(int j=0; j< arr.length; j++){
                arr[i][j] = i * arr.length + j;
            }
        }

        int count = 0;
        for(int j= result.length -1; j >=0; j--){
            for(int i=0; i < result.length; i++){
//                result[i][j] = (result.length -1 -j) * result.length + i;
                result[i][j] = count;
                count++;
            }
        }

        if(equals(rotateMatrix(arr), result)){
            System.out.println("Tests passed");
        } else{
            System.out.println("Tests failed");
        }
    }
}
