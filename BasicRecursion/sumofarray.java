import java.util.*;
/**
 * sumofarray
 */
public class sumofarray {

    public static void main(String[] args) {
        int[] input = { 10, 20, 30, 40, 50 };
        System.out.println(sum(input));

    }

    public static int sum(int input[]) {
        return sumutil(input,input.length-1);
		
		
    }

    private static int sumutil(int[] input, int n) {
        if (n == 0) {
            return input[n];
        }
        int smallsum = sumutil(input, n - 1);
        return input[n] + smallsum;
        
    }
}
