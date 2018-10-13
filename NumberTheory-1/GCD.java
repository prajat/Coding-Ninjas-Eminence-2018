import java.util.*;
/**
 * GCD
 */
public class GCD {

    public static void main(String[] args) {

        System.out.println(gcd(16,10));
    }
    
    public static int gcd(int a, int b) {
      
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}