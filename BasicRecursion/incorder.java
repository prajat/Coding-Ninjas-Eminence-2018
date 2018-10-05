import java.util.*;
/**
 * incorder
 */
public class incorder {

    public static void main(String[] args) {

        print(6);
    }
    
    public static void print(int n) {
        if (n == 0) {
            return;
        }

        print(n - 1);
        System.out.print(n + " ");
    }
}