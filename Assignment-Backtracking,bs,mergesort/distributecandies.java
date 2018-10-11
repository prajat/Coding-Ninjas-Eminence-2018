import java.util.*;


/**
 * distributecandies
 */
public class distributecandies {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int j= 1; j <= t; j++) {
            int n = s.nextInt();
            int k = s.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = s.nextInt();
            }
            System.out.println(solve(arr, k));
        }
    }

    public static int solve(int[] arr, int k) {
        int start = 0;
        int[] temp = arr;
        Arrays.sort(temp);
        int end = temp[temp.length - 1];

        int ans = 0;
        while (start < end) {
            int mid = (start + end) / 2;
            if (check(arr, mid, k)) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }
        return ans;

    }

    public static boolean check(int[] arr, int mid, int k) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int smallans = arr[i] / mid;
            count += smallans;

            if (count == k) {
                return true;
            }
        }
        return false;
        
    }
}