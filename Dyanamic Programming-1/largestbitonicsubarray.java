
public class largestbitonicsubarray {

    public static int longestBitonicSubarray(int[] arr) {

        /*
         * Your class should be named Solution. Don't write main() function. Don't read
         * input, it is passed as function argument. Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */
        return lbs(arr, arr.length);

    }

    public static int lbs(int arr[], int n) {
        int i, j;

        int[] lis = new int[n];
        for (i = 0; i < n; i++)
            lis[i] = 1;

        for (i = 1; i < n; i++)
            for (j = 0; j < i; j++)
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1;

        int[] lds = new int[n];
        for (i = 0; i < n; i++)
            lds[i] = 1;

        for (i = n - 2; i >= 0; i--)
            for (j = n - 1; j > i; j--)
                if (arr[i] > arr[j] && lds[i] < lds[j] + 1)
                    lds[i] = lds[j] + 1;

        int max = lis[0] + lds[0] - 1;
        for (i = 1; i < n; i++)
            if (lis[i] + lds[i] - 1 > max)
                max = lis[i] + lds[i] - 1;

        return max;
    }

}
