import java.util.*;

/**
 * cointower
 */
public class cointower {

    public static void main(String[] args) {

        System.out.println(solve(4, 2, 3));
    }

    public static String solve(int n, int x, int y) {

        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[x] = 1;
        dp[y] = 1;
        for (int i = 2; i <=n; i++) {
            if (dp[i] == 0) {
                dp[i] = dp[i - 1] ^ 1;
                if (i - x >= 1) {
                    dp[i] = Math.max(dp[i], dp[i - x]^1);
                }
                if (i - y >= 1) {
                    dp[i] = Math.max(dp[i], dp[i - y]^1);

                }
            }

        }
        if (dp[n] != 0) {
            return "Beerus";
        }
        else {
            return "Whis";
        }
    }
}