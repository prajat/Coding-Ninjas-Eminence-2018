import java.util.*;

import javafx.util.Pair;

public class ActivitySelection {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        // Pair<Integer, Integer>[] activity = new Pair[n];
        ArrayList<Pair<Integer, Integer>> activity = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int first = s.nextInt();
            int second = s.nextInt();
            activity.add(new Pair<Integer, Integer>(first, second));

        }

        Collections.sort(activity, new Comparator<Pair<Integer, Integer>>() {
            public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
                return p1.getValue().compareTo(p2.getValue());
            }
        });
        int ans = 1;
        int finishtime = activity.get(0).getValue();
        for (int i = 1; i < activity.size(); i++) {
            if (activity.get(i).getKey() >= finishtime) {
                ans++;
                finishtime = activity.get(i).getValue();
            }

        }
        System.out.println(ans);
    }

}