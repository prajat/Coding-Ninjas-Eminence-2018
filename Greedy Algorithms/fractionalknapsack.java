import java.util.*;
/**
 * fractionalknapsack
 */
public class fractionalknapsack {

    public static class worker {
        int t, x, y;

        worker(int tt, int xx, int yy) {
            this.t = tt;
            this.x=xx;
            this.y=yy;

        }
    }

    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long area = s.nextLong();
        ArrayList<worker> workerlist = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int t = s.nextInt();
            int x = s.nextInt();
            int y = s.nextInt();
            workerlist.add(new worker(t, x, y));

        }
        Collections.sort(workerlist, new Comparator<worker>() {
            public int compare(worker a, worker b) {
                if (a.t == b.t) {
                    if (a.y == b.y) {
                        return a.x - b.x;
                    }
                    return b.y-a.y;
                }
                return a.t-b.t;
            }
        });

        int mincost = 0;
        long currarea = 0;
        long bestspeed = 0;
        long lasttime = workerlist.get(0).t;
        for (int i = 1; i < n; i++) {
            long currworkingarea = bestspeed * 1 * (workerlist.get(i).t - lasttime);
            currarea += currworkingarea;
            if (currarea > area) {
                break;
            }
            if (workerlist.get(i).y > bestspeed) {
                bestspeed = workerlist.get(i).y;
                mincost += workerlist.get(i).x;

            }
            lasttime = workerlist.get(i).t;
        }
        System.out.println(mincost);



    }
}