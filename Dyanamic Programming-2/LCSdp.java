import java.util.*;

/**
 * LCSrecursive
 */
public class lcsdp {

    public static void main(String[] args) {

        String a = "dgei";
        String b = "begi";
        System.out.println(lcs(a, b));

    }

    public static int lcs(String a, String b) {
        int[][] storage = new int[a.length() + 1][b.length() + 1];
        return lcs(a, b, storage);

    }

    public static int lcs(String a, String b, int[][] storage) {

        int m = a.length();
        int n = b.length();

        if (storage[m][n] > 0) {
            return storage[m][n];
        }
        if (m == 0 || n == 0) {
            storage[m][n] = 0;
            return storage[m][n];
        }
        if (a.charAt(0) == b.charAt(0)) {
            storage[m][n] = 1 + lcs(a.substring(1), b.substring(1), storage);
            return storage[m][n];

        } else {
            int op1 = lcs(a.substring(1), b, storage);
            int op2 = lcs(a, b.substring(1), storage);
            storage[m][n] = Math.max(op1, op2);
            return storage[m][n];
        }

    }
}