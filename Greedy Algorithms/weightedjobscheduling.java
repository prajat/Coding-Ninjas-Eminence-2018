import java.util.*;
/**
 * weightedjobscheduling
 */
public class weightedjobscheduling {


    public static class job {
        int start, finish, profit;

        job(int s, int f, int p) {
            this.start = s;
            this.finish = f;
            this.profit = p;

        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        ArrayList<job> joblist = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int ss = s.nextInt();
            int f = s.nextInt();
            int p = s.nextInt();

            joblist.add(new job(ss, f, p));

        }
        
        Collections.sort(joblist, new Comparator<job>() {
            public int compare(job a, job b) {
                return a.finish - b.finish;
            }
        });

        int[] dp = new int[n];
        dp[0] = joblist.get(0).profit;
        for (int i = 1; i < n; i++) {
            int including = joblist.get(i).profit;
            int lmconflict = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (joblist.get(j).finish <= joblist.get(i).start) {
                    lmconflict = j;
                    break;
                }
            }
            if (lmconflict != -1) {
                including += dp[lmconflict];
            }
            dp[i] = Math.max(including, dp[i - 1]);
        }
        System.out.println(dp[n-1]);
    }
}