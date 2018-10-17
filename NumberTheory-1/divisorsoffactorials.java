import java.util.*;
/**
 * divisorsoffactorials
 */
public class divisorsoffactorials {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        
        while (t--) {
            int n = s.nextInt();
            ArrayList<Integer> list = seive(n);
            System.out.println(divisors(n,list));
        }
    }

    public static ArrayList<Integer> seive(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] isprime = new int[50001];
        for (int i = 2; i <isprime.length; i++) {
            isprime[i] = true;

        }
        isprime[0] = false;
        isprime[1] = false;
        for (int i = 2; i * i <isprime.length; i++) {
            for (int j = i * i; j <isprime.length; j++) {
                if (isprime[i]) {
                    isprime[j] = false;

                }
            }
        }
        list.add(2);
        for (int i = 3; i <isprime.length; i++) {
            if (isprime[i]) {
                lsit.add(i);
            }
        }
        return list;
        
    }

    public static long divisors(int n, ArrayList<Integer> list) {
        long mod = 1000000007;
        long result = 1;    
        for(int i=0;list.get(i)<=n;i++)
        {
            int k=list.get(i);
            long count = 0;
            while (n / k != 0) {
                count += (n / k) % mod;

                k = k * list.get(i);
            }
            result = (result * (count + 1) % mod) % mod;

        }
        return count;  
    }
}