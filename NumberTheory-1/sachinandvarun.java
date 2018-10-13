import java.util.Scanner;
import java.util.*;

public class Main {

    public static class triplet {
        public long gcd;
        long x;
        long y;

        public triplet() {
            this.gcd = 0;
            this.x = 0;
            this.y = 0;
        }
    }

    public static triplet extendedgcd(long a, long b) {
        if (b == 0) {
            triplet myans = new triplet();
            myans.gcd = a;
            myans.x = 1;
            myans.y = 0;
            return myans;
        }
        triplet smallans = extendedgcd(b, a % b);
        triplet myans = new triplet();
        myans.gcd = smallans.gcd;
        myans.x = smallans.y;
        myans.y = (smallans.x - ((a / b) * (smallans.y)));
        return myans;

    }

    public static long modinverse(long a, long m) {
        long x = extendedgcd(a, m).x;
        return (x % m + m) % m;

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long t = s.nextLong();
        for (int i = 1; i <= t; i++) {
            long a = s.nextLong();
            long b = s.nextLong();
            long d = s.nextLong();

            triplet k = extendedgcd(a, b);
            long g = k.gcd;
            if (d % g != 0) {
                System.out.println(0);
                continue;
            }
            if (d == 0) {
                System.out.println(1);
                continue;
            }

            a /= g;
            b /= g;
            d /= g;

            long y1 = ((d % a) * modinverse(b, a)) % a;
            long firstvalue = d / b;
            if (d < y1 * b) {
                System.out.println(0);
                continue;
            }
            long ans = (firstvalue - y1) / a;
            long myans = ans + 1;
            System.out.println(myans);
        }
    }

    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}