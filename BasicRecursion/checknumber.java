import java.util.*;
/**
 * checknumber
 */
public class checknumber {

    public static void main(String[] args) {

        int[] input = { 1, 2, 4, 6 };
        System.out.println(checkNumber(input, 0));
    }
    
    public static boolean checkNumber(int input[], int x) {
        return check(input, 0, x);

    }

    public static boolean check(int[] input, int starti, int x) {
        if (starti == input.length) {
            return false;
        }

        if (input[starti] == x) {
            return true;
        }
        return check(input, starti + 1, x);

        
    }
}