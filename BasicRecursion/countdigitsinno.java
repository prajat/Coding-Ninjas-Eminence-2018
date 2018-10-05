import java.util.*;
/**
 * countdigitsinno
 */
public class countdigitsinno {

    public static void main(String[] args) {

        System.out.println(count(256));
    }

    private static int count(int n) {
        if (n / 10 == 0) {
            return 1;
        }
        return 1 + count(n / 10);
        
    }           
}