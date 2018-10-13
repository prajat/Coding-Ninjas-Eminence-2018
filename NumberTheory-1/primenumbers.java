import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        boolean[] isprime = new boolean[n + 1];
        isprime[0] = false;
        isprime[1] = false;
        for (int i = 2; i <= n; i++) {
            isprime[i] = true;
        }
        for (int i = 2; i * i <= n; i++) {
            for (int j = i * i; j <= n; j += i) {
                if (isprime[i] == true) {
                    isprime[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 0; i <= n; i++) {
            if (isprime[i] == true) {
                count++;
            }
        }
        System.out.println(count);

    }
}