import java.util.*;
/**
 * LIS_DP
 */
public class LIS_DP {

    public static void main(String[] args) {

        int[] input={5, 4 ,11 ,1, 16 ,8};
        System.out.println(lis(input, input.length));
    }

    public static int lis(int[] input, int n) {
        int[] output = new int[n];
        output[0] = 1;
        for (int i = 1; i < n; i++) {
            output[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (input[j] > input[i]) {
                    continue;
                }
                int possibleans = output[j] + 1;
                if (possibleans > output[i]) {
                    output[i] = possibleans;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (output[i] > max) {
                max = output[i];
            }
        }
        return max;
        
    }
}