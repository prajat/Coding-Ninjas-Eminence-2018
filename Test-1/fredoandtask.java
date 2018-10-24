import java.util.*;
/**
 * fredoandtask
 */
public class fredoandtask {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long n = s.nextLong();

        long max = 1000000000;
        long x = 0;
        double total = 0;
        for (long i = 0; i < n; i++) {
            x = s.nextLong();
            total += Math.log(x);
        }
        long start = 1;
        long end = max;
        long answer, mid;
        while (start <= end) {
            mid = (start + end) / 2;

            if (n * log(mid) > total) {
                end = mid - 1;
                answer = mid;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(answer);
    }
        
}