import java.util.*;

public class solution {

    public static long solve(int[] A, int n) {

        long anscount = mergesort(A, 0, n - 1);

        return anscount;
    }

    public static long mergesort(int[] A, int left, int right) {
        long count = 0;

        while (right > left) {
            int mid = (left + right) / 2;
            long leftcount = mergesort(A, left, mid);
            long rightcount = mergesort(A, mid + 1, right);
            long mergingcount = merge(A, left, right, mid + 1);
            return leftcount + rightcount + mergingcount;
        }
        return count;

    }

    public static long merge(int[] A, int left, int right, int mid) {
        int[] temp = new int[right - left + 1];
        long count = 0;
        int i = left;
        int j = mid;
        int k = 0;

        while (i < mid && j <= right) {
            if (A[i] <= A[j]) {
                temp[k++] = A[i++];

            } else {
                temp[k++] = A[j++];
                count += mid - i;
            }
        }
        while (i < mid) {
            temp[k++] = A[i++];
        }
        while (j <= right) {
            temp[k++] = A[j++];
        }
        for (int m = left, n = 0; m <= right; m++, n++) {
            A[m] = temp[n];
        }
        return count;

    }

}
