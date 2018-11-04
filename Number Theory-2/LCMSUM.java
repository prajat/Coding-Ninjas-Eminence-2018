import java.util.*;
/**
 * LCMSUM
 */
public class LCMSUM {

    public static void main(String[] args) {

    }
    
    public static void func(long n) {


        long sum = n;
        for (long i = 2; i <= n; i++) {
            long product = i * n;
            sum += product / gcd(n, i);
        }
        System.out.println(sum);
    }

    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
        
    }
}