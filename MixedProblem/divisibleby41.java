import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int t = s.nextInt();
        for (int i = 1; i <= t; i++) {
            int a0 = s.nextInt();
            int a1 = s.nextInt();
            int c = s.nextInt();
            int n = s.nextInt();
            int[] a = new int[n];
            a[0] = a0;
            if (n > 1) {
                a[1] = a1;
            }
            if (n == 1) {
                a1 = 0;
            }
            int ans = ((a[0] * 10) + a1) % 41;
            for (int j = 2; j < n; j++) {
                a[j] = (a[j - 1] * c + a[j - 2]) % 10;
                ans = ((ans * 10) + a[j]) % 41;
            }
            if (ans == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }

    }

}