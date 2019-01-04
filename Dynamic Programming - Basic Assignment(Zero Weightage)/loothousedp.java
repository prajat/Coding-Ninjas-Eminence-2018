import java.util.*;

/**
 * loothouses
 */
public class loothousedp {

    public static void main(String[] args) {

        int[] arr = { 5, 5, 10, 100, 10, 5 };
        System.out.println(getMaxMoney(arr, arr.length));
    }

    public static int getMaxMoney(int arr[], int n) {


        int[] storage = new int[n];
        return getMaxMoney(arr, n, 0,storage);

    }

    private static int getMaxMoney(int[] arr, int n, int start, int[] storage) {

        
        if (storage[start] > 0) {
            return storage[start];
        }
        if (start == n - 2) {
            storage[start] = Math.max(arr[n - 1], arr[n - 2]);
            return storage[start];
        }
        if (start == n - 1) {
            storage[start] = arr[start];
            return storage[start];

        }

        int op1 = arr[start] + getMaxMoney(arr, n, start + 2,storage);
        int op2 = getMaxMoney(arr, n, start + 1,storage);
        storage[start] = Math.max(op1, op2);
        return storage[start];

    }
}