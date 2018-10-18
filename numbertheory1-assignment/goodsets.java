import java.util.Scanner;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = s.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = s.nextInt();
            }
            System.out.println(goodsets(arr));
        }
    }

    public static int goodsets(int[] arr) {
        int mod = 1000000007;
        Arrays.sort(arr);
        int[] seive = new int[(int) (7.5 * 100000 + 1)];
        for (int i = 0; i < arr.length; i++) {
            seive[arr[i]] = 1;
        }
        for (int i = 0; i < seive.length; i++) {
            if (seive[i] > 0) {
                for (int j = i + i; j < seive.length; j = j + i) {
                    if (seive[j] > 0) {
                        seive[j] = (seive[j] % mod + seive[i] % mod) % mod;
                    }
                }
            }
        }
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result = (result % mod + seive[arr[i]] % mod) % mod;
        }
        return result;

    }

}