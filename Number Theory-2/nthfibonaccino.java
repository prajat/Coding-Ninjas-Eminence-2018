import java.util.*;
/**
 * nthfibonaccino
 */
public class nthfibonaccino {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(fib(n));
    }

    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n==2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
        
    }
}