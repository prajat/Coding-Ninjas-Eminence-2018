import java.util.*;
/**
 * printsubsetofarray
 */
public class printsubsetofarray {

    public static void main(String[] args) {

    }
    
    public static void printSubsets(int input[]) {
        // Write your code here
        int[] output = new int[0];
        printSubsets(input, 0,output);

    }

    public static void printSubsets(int[] input, int start,int[] output) {
        if (start == input.length) {
            for (int i = 0; i < output.length; i++) {
                System.out.print(output[i] + " ");
            }
            System.out.println();
            return;

        }
        int[] newoutput = new int[output.length + 1];
        int i = 0;
        for (; i < output.length; i++) {
            newoutput[i] = output[i];
        }
        newoutput[i] = input[start];
        printSubsets(input, start + 1, output);
        printSubsets(input, start + 1, newoutput);
        
        
    }
}