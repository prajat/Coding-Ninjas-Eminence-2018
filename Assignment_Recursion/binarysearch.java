import java.util.*;
/**
 * binarysearch
 */
public class binarysearch {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 5, 6, 7 };
        System.out.println(binarySearch(arr, 7));

    }

    public static int binarySearch(int input[], int element) {
        // Write your code here
        return binarySearch(input, element, 0, input.length - 1);

    }

    public static int binarySearch(int[] input, int element, int start, int end) {

        int mid = (end + start) / 2;
        if (start >= end) {
            return -1;
        }
        if (input[mid] == element) {
            return mid;

        }
        if (element > input[mid]) {
            return binarySearch(input, element, mid + 1, end);
        }
        return binarySearch(input, element, start, mid - 1);

    }
}
