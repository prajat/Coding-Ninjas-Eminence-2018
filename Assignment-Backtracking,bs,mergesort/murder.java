import java.util.Scanner;
import java.util.*;

public class murder {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 1; i <= t; i++) {

            int l = s.nextInt();
            long[] arr = new long[l];
            for (int j = 0; j < l; j++) {
                arr[j] = s.nextLong();
            }

            System.out.println(mergesort(arr, 0, l - 1));
        }

    }

    public static long mergesort(long[] arr, int start, int end) {
        long sum = 0;
        while (start < end) {
            int mid = (start + end) / 2;
            long leftsum = mergesort(arr, start, mid);
            long rightsum = mergesort(arr, mid + 1, end);
            long mergingsum = merge(arr, start, end, mid + 1);
            return leftsum + rightsum + mergingsum;
        }

        return sum;
    }

    public static long merge(long[] arr, int start, int end, int mid) {
        long sum = 0;
        int i = start;
        int j = mid;
        long[] temp = new long[end - start + 1];

        int k = 0;
        while (i < mid && j <= end) {
            if (arr[i] < arr[j]) {
                sum += (end - j + 1) * arr[i];
                temp[k++] = arr[i++];
                

            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i < mid) {
            temp[k++] = arr[i++];
        }
        while (j <= end) {
            temp[k++] = arr[j++];

        }
        for (int m = start, n = 0; m <= end; m++, n++) {
            arr[m] = temp[n];
        }
        return sum;

    }

}