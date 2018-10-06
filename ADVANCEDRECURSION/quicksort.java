import java.util.*;

/**
 * quicksort
 */
public class quicksort {

    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 4, 7, 6 };
        quickSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }

    }
    
    public static void quickSort(int[] input) {

        if (input.length == 0 || input.length == 1) {
            return;
        }
        quickSort(input, 0, input.length - 1);
    }

    public static void quickSort(int[] input, int start, int end) {
        if (start >= end) {
            return;
        }
        
        int c = partition(input, start, end);
        quickSort(input, start, c - 1);
        quickSort(input, c + 1, end);

    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
        
        
    }
}