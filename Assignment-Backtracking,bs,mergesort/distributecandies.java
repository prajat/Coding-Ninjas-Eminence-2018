import java.util.*;


/**
 * distributecandies
 */
public class distributecandies {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int j= 1; j <= t; j++) {
            long n = s.nextLong();
            long k = s.nextLong();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = s.nextLong();
            }
            System.out.println(solve(arr, k));
        }
    }

    public static int solve(long[] arr, long k) {
        long start = 0;
        long[] temp = arr;
        Arrays.sort(temp);
        long end = temp[temp.length - 1];

        int ans = 0;
        while (start < end) {
            long mid = (start + end) / 2;
            if (check(arr, mid, k)) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }
        return ans;

    }

    public static boolean check(long[] arr, long mid, long k) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int smallans = arr[i] / mid;
            count += smallans;

            if (count >= k) {
                return true;
            }
        }
        return false;
        
    }
}