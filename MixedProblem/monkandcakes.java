import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

class Pair implements Comparable<Pair> {
    long weight;
    long no;

    @Override
    public int compareTo(Pair o) {
        return (int) (o.weight - this.weight);
    }
}

public class Main {

    public static boolean check(long[] capacity, Pair[] cakes, long time) {
        long eat = 0, total = time;
        int i = 0, j = capacity.length - 1;
        while (i < cakes.length) {
            long temp = cakes[i].no - eat;

            if (j == -1 || cakes[i].weight > capacity[j])
                return false;

            if (temp > total) {
                eat += total;
                j--;
                total = time;
            } else if (temp == total) {
                i++;
                j--;
                total = time;
                eat = 0;
            } else {
                total -= temp;
                eat = 0;
                i++;
            }
        }
        return true;
    }

    public static long find(long st, long end, long[] capacity, Pair[] cakes) {
        long ans = -1;
        while (st <= end) {
            long mid = (end - st) / 2 + st;
            if (check(capacity, cakes, mid)) {
                ans = mid;
                end = mid - 1;
            } else
                st = mid + 1;

        }
        return ans;
    }

    public static void main(String[] args) {
        // Write your code here
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0) {
            int n = s.nextInt(), m = s.nextInt();
            long[] capacity = new long[m];
            for (int i = 0; i < m; i++)
                capacity[i] = s.nextLong();
            Arrays.sort(capacity);
            Pair[] cakes = new Pair[n];
            for (int i = 0; i < n; i++) {
                cakes[i] = new Pair();
                cakes[i].weight = s.nextInt();
            }
            long total = 0;
            for (int i = 0; i < n; i++) {
                cakes[i].no = s.nextInt();
                total += cakes[i].no;
            }
            Arrays.sort(cakes);
            if (cakes[0].weight > capacity[m - 1])
                System.out.println(-1);
            else
                System.out.println(find(total / cakes.length, total, capacity, cakes));
        }
    }

}