import java.util.*;

/**
 * printallpermutations
 */
public class printallpermutations {

    public static void main(String[] args) {

        permutations("abc");
    }
    
    public static void permutations(String input) {
        // Write your code here
        permutations(input, "");

    }

    public static void permutations(String input, String output) {
        if (input.length() == 0) {
            System.out.println(output);
            return;
        }
        for (int i = 0; i < input.length(); i++) {
            char cc = input.charAt(i);
            permutations(input.substring(0,i)+input.substring(i+1), cc+output);

        }
        
    }
}