import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] primes = new int[1000001];
        primes[0] = 0;
        primes[1] = 0;
        primes[2] = 1;

        for (int i = 2 * 2; i < primes.length; i = i + 2) {
            primes[i] = 1;
        }
        for (int i = 3; i < primes.length; i = i + 2) {

            if (primes[i] == 0) {

                for (int j = i; j < primes.length; j = j + i) {
                    primes[j]++;
                }
            }

        }
        int[][] factors = new int[11][1000001];
        for (int i = 1; i < factors.length; i++) {
            for (int j = 1; j < primes.length; j++) {
                if (primes[j] == i) {
                    factors[i][j] = factors[i][j - 1] + 1;
                } else {
                    factors[i][j] = factors[i][j - 1];

                }
            }
        }

        int t = s.nextInt();
        for (int i = 1; i <= t; i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            int n = s.nextInt();
            if (n == 0 && a == 1) {
                System.out.println(1);

            } else {
                int ans = factors[n][b] - factors[n][a - 1];
                System.out.println(ans);
            }

        }

    }

}