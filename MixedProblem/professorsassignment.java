import java.util.*;
/**
 * professorsassignment
 */
public class professorsassignment {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //int n = s.nextInt();
        int mod = 1000000007;
        int n = 5;

        //int inv = 0.5 % mod;
        int sum = 0;
        for (int i = 1; i <= n;) {
            int x = n / i;
            int j = n / x;
            int y = (j - i + 1)  * ((x * (x + 1))/2) ;

            //sum = (sum % mod + y % mod) % mod;
            sum += y;
            i = j + 1;

        }
        System.out.println(sum);
    }
}