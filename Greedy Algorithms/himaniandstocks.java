import java.util.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Write your code here
        Scanner s = new Scanner(System.in);
        long mod = (long) Math.pow(2, 32);

        int n = s.nextInt();
        long m = s.nextLong();
        long a = s.nextLong();
        long b = s.nextLong();

        long[] profit = new long[n + 1];
        profit[0] = 0;
        long x = 0;
        for (int i = 1; i <= n; i++) {
            x = ((x % m) * a + b) % mod;
            profit[i] = x >> 8;

        }
        long maxprofit = 0 - profit[1];
        for (int i = 2; i <= n; i++) {
            if (profit[i] < profit[i - 1]) {
                maxprofit = maxprofit + profit[i - 1] - profit[i];
            }
        }
        maxprofit += profit[n];
        System.out.println(maxprofit);

    }

}