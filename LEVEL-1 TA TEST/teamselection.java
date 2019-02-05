import java.util.*;

/**
 * subsetsoffixedsize
 */
public class subsetsoffixedsize {

    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.nextInt();

        }
        int[] output = new int[0];
        printSubsets(arr, 0, output, 12);
    }

    public static void printSubsets(int[] input, int start, int[] output, int k) {
        if (start == input.length) {

            if (output.length == k) {
                for (int i = 0; i < output.length; i++) {
                    System.out.print(output[i] + " ");
                }
                System.out.println();
            }
            return;

        }
        int[] newoutput = new int[output.length + 1];
        int i = 0;
        for (; i < output.length; i++) {
            newoutput[i] = output[i];
        }
        newoutput[i] = input[start];
        printSubsets(input, start + 1, output, k);
        printSubsets(input, start + 1, newoutput, k);

    }
}