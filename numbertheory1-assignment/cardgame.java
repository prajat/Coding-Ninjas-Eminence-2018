import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.util.HashMap;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Map;
import java.io.BufferedReader;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskE solver = new TaskE();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskE {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            long k = in.nextLong();
            long[] a = in.readLongArray(n);

            if (k == 1) {
                out.println(((long) n * n + n) / 2);
                return;
            }

            List<Long> pfList = Numerics.primeFactors(k);
            Map<Long, Long> pfMap = new HashMap<>();
            for (Long pf : pfList) {
                if (pfMap.containsKey(pf)) {
                    pfMap.put(pf, pfMap.get(pf) + 1);
                } else {
                    pfMap.put(pf, 1L);
                }
            }

            int last = -1;

            Map<Long, Long> pfCount = new HashMap<>();
            for (Long targetFactor : pfMap.keySet()) {
                pfCount.put(targetFactor, 0L);
            }

            long result = 0;
            for (int first = 0; first < n; first++) {
                while ((last < n - 1) && (!containsAllFactors(pfCount, pfMap))) {
                    last++;
                    addFactors(pfCount, a[last], pfMap);
                }
                if (containsAllFactors(pfCount, pfMap)) {
                    result += n - last;
                } else {
                    break;
                }
                removeFactors(pfCount, a[first], pfMap);
            }
            out.println(result);
        }

        void addFactors(Map<Long, Long> count, Long x, Map<Long, Long> target) {
            for (Long targetFactor : target.keySet()) {
                while (x % targetFactor == 0) {
                    x /= targetFactor;
                    count.put(targetFactor, count.get(targetFactor) + 1);
                }
            }
        }

        void removeFactors(Map<Long, Long> count, Long x, Map<Long, Long> target) {
            for (Long targetFactor : target.keySet()) {
                while (x % targetFactor == 0) {
                    x /= targetFactor;
                    count.put(targetFactor, count.get(targetFactor) - 1);
                }
            }
        }

        boolean containsAllFactors(Map<Long, Long> test, Map<Long, Long> target) {
            for (Long targetFactor : target.keySet()) {
                if (test.get(targetFactor) < target.get(targetFactor)) {
                    return false;
                }
            }
            return true;
        }

    }

    static class Numerics {
        public static List<Long> primeFactors(long n) {
            List<Long> result = new ArrayList<Long>();
            while (n % 2 == 0) {
                result.add(2L);
                n = n / 2;
            }

            for (long i = 3; i <= Math.sqrt(n); i += 2) {
                while (n % i == 0) {
                    result.add(i);
                    n = n / i;
                }
            }

            if (n > 2)
                result.add(n);
            return result;
        }

    }

    static class InputReader {
        private static BufferedReader in;
        private static StringTokenizer tok;

        public InputReader(InputStream in) {
            this.in = new BufferedReader(new InputStreamReader(in));
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public long[] readLongArray(int n) {
            long[] ar = new long[n];
            for (int i = 0; i < n; i++) {
                ar[i] = nextLong();
            }
            return ar;
        }

        public String next() {
            try {
                while (tok == null || !tok.hasMoreTokens()) {
                    tok = new StringTokenizer(in.readLine());
                    // tok = new StringTokenizer(in.readLine(), ", \t\n\r\f"); //adds commas as
                    // delimeter
                }
            } catch (IOException ex) {
                System.err.println("An IOException was caught :" + ex.getMessage());
            }
            return tok.nextToken();
        }

    }
}