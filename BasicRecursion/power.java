import java.util.*;
/**
 * power
 */
public class power {

    public static void main(String[] args) {
        System.out.println(power(2, 3));

    }
    public static int power(int x, int n) {
        if (n == 1) {
            return x;
        }
        return x * power(x, n - 1);
      
		
	}
}
