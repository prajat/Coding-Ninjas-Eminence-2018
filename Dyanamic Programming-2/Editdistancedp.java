import java.util.*;

/**
 * editdistancerecursive
 */
public class Editdistancedp {

    public static void main(String[] args) {

        String a = "adef";
        String b = "gbed";
        System.out.println(editDistance(a, b));
    }

    public static int editDistance(String a, String b) {
        int[][] storage = new int[a.length() + 1][b.length() + 1];
        return editDistance(a, b,storage);
        
    }

    public static int editDistance(String a, String b, int[][] storage) {
        int m = a.length();
        int n = b.length();
        if (storage[m][n] > 0) {
            return storage[m][n];

        }

        
        
        
        if (m== 0) {
            storage[m][n] = n;
            return storage[m][n];

        }
        if (n== 0) {
            storage[m][n] = m;
            return storage[m][n];

        }
        if (a.charAt(0) == b.charAt(0)) {
            storage[m][n] = editDistance(a.substring(1), b.substring(1), storage);
            return storage[m][n];

        } else {
            int op1 = editDistance(a, b.substring(1),storage);
            int op2 = editDistance(a.substring(1), b,storage);
            int op3 = editDistance(a.substring(1), b.substring(1),storage);
            storage[m][n] = 1 + Math.min(op1, Math.min(op2, op3));
            return storage[m][n];
        }

    }
}