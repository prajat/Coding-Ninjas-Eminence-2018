import java.util.*;

public class Solution {

    public static int kthLargest(int arr[], int k) {
        /*
         * Your class should be named Solution Don't write main(). Don't read input, it
         * is passed as function argument. Return output and don't print it. Taking
         * input and printing output is handled automatically.
         */
        Arrays.sort(arr);
        return arr[arr.length - k];
    }
}
