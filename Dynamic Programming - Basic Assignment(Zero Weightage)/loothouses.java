import java.util.*;


/**
 * loothouses
 */
public class loothouses {

    public static void main(String[] args) {

        int[] arr = { 5, 5, 10, 100, 10, 5 };
        System.out.println(getMaxMoney(arr, arr.length));
    }

    public static int getMaxMoney(int arr[], int n) {
        

        return getMaxMoney(arr, n, 0);
        
    }

    private static int getMaxMoney(int[] arr, int n, int start) {
        

        if (start == n - 2) {
            return Math.max(arr[n- 1], arr[n- 2]);
        }
        if (start == n - 1) {
            return arr[start];

        }
        
        int op1 = arr[start] + getMaxMoney(arr, n, start + 2);
        int op2 = getMaxMoney(arr, n, start + 1);
        return Math.max(op1, op2);


    }
}