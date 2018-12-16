package problems.arraysAndStrings;


// Cracking the Code Interview Sixth Edition (Problem 1.6)
// Implement a method to perform basic string compression using the counts of repeated characters.
// For example, the string aabcccccaaa would become a2b1c5a3.
// If the "compressed" string would not become smaller than the original string, your method should return the original string.
// You can assume the string has only uppercase and lowercase letters (a-z).

public class StringCompression {

    private static String stringCompression(String string){
        if(string == null || string.isEmpty()){
            return string;
        }
        String compressedString = compress(string);

        return compressedString.length() > string.length() ? string: compressedString;
    }

    private static String compress(String str){
        char current = str.charAt(0);
        int count = 0;
        StringBuilder builder = new StringBuilder();

        for(char c: str.toCharArray()){
            if(current == c){
                count++;
            } else{
                builder.append(current).append(count);
                current = c;
                count = 1;
            }
        }
        builder.append(current).append(count);
        return builder.toString();
    }


    public static void main(String[] args){
        String aabcccccaaa = "aabcccccaaa";
        String a2b1c5a3 = "a2b1c5a3";
        String abcd = "abcd";

        if(stringCompression(aabcccccaaa).equals(a2b1c5a3) && stringCompression(abcd).equals(abcd)) {
            System.out.println("Tests passed");
        } else{
            System.out.println("Tests failed");
        }
    }
}
