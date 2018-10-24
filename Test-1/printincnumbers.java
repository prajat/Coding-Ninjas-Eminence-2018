import java.util.*;
/**
 * printincnumbers
 */
public class printincnumbers {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        printincnumber(n, "");
    }

    public static void printincnumber(int n, String str) {
        if (n <= 0) {
            System.out.print(str + " ");
            return;
        }

        if (str.length() == 0) {
            for (int i = 1; i <= 9; i++) {
                String x = Integer.toString(i);
                printincnumber(n - 1, str + x);
            }
        } else {
            for (int i = str.charAt(str.length() - 1) - '0' + 1; i <= 9; i++) {
                String x = Integer.toString(i);
                printincnumber(n - 1, str + x);
            }
        }

    }
    
}