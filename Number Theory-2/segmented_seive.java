import java.util.*;
/**
 * segmented_seive
 */
public class segmented_seive {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        ArrayList<Integer> list = seive();
        for (int i = 1; i <= t; i++) {
            long l = s.nextLong();
            long u = s.nextLong();
            printprimes(l, u,list);
        }
    }

    public static ArrayList<Integer> seive() {
        boolean[] isprime = new boolean[100001];
        for (int i = 0; i < isprime.length; i++) {
            isprime[i] = true;
        }
        for (int i = 2; i * i <= isprime.length; i++) {
            if (isprime[i] == true) {
                for (int j = i * i; j < isprime.length; j += i) {
                    isprime[j] = false;
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        for(int i=3;i<isprime.length;i+=2;){
            if(isprime[i]==true){
                list.add(i);
            }
        }
        return list;

        
    }

    public static void printprimes(long l, long u, ArrayList<Integer> list) {
        boolean[] isprime = new boolean[r - l + 1];
        for (int i = 0; i <= r - l; i++) {
            isprime[i] = true;
        }
        for (int i = 0; list.get(i) * (long) list.get(i) <= r; i++) {
            int currprime = list.get(i);
            long base = (l / currprime) * currprime;
            if (base < l) {
                base += currprime;
            }
            for (long j = base; j <= r; j += currprime) {
                isprime[j - l] = false;

            }
            if (base == currprime) {
                isprime[base - l] = true;
            }
        }
        for (int i = 0; i < r - l; i++) {
            if (isprime[i] == true) {
                System.out.println(i+l);
            }
        }
        
    }
}