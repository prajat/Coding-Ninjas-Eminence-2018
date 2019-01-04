import java.util.*;
/**
 * coinchange
 */
public class coinchange {

    public static void main(String[] args) {

        int[] den = { 1, 2, 3 };
        int value = 4;
        System.out.println(countWaysToMakeChange(den, value));
    }

    public static int countWaysToMakeChange(int denominations[], int value){
        int[][] storage = new int[value + 1][denominations.length + 1];
        int n = value;
        int k = denominations.length;
        return countWaysToMakeChange(denominations, n,k, storage);
        
    }

    private static int countWaysToMakeChange(int[] denominations, int n, int k, int[][] storage) {
        if (n == 0) {
            // storage[n][k] = 1;
            // return storage[n][k];
            return 1;
        }
        if (n < 1 || k == 0) {

            // storage[n][k] = 0;
            // return storage[n][k];
            return 0;

        }
        if (storage[n][k] > 0) {
            return storage[n][k];

        }
        
        

        int op1 = countWaysToMakeChange(denominations, n - denominations[k-1], k, storage);
        int op2 = countWaysToMakeChange(denominations, n, k - 1, storage);
        storage[n][k] = op1 + op2;
        return storage[n][k];
    }
}