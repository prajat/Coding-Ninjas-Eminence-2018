public class Solution {

    public static long fiboSum(long m, long n) {
        // Write your code here
        long first = fib(m + 2);
        long second = fib(n + 1);
        return (first - second);
    }

    public static void multiply(long[][] A, long[][] M) {
        A[0][0] %= 1000000007;
        A[0][1] %= 1000000007;
        A[1][0] %= 1000000007;
        A[1][1] %= 1000000007;

        M[0][0] %= 1000000007;
        M[0][1] %= 1000000007;
        M[1][0] %= 1000000007;
        M[1][1] %= 1000000007;

        long first = (A[0][0] * M[0][0]) % 1000000007 + (A[0][1] * M[1][0]) % 1000000007;
        long second = (A[0][0] * M[0][1]) % 1000000007 + (A[0][1] * M[1][1]) % 1000000007;
        long third = (A[1][0] * M[0][0]) % 1000000007 + (A[1][1] * M[1][0]) % 1000000007;
        long fourth = (A[1][0] * M[0][1]) % 1000000007 + (A[1][1] * M[1][1]) % 1000000007;

        A[0][0] = first % 1000000007;
        A[0][1] = second % 1000000007;
        A[1][0] = third % 1000000007;
        A[1][1] = fourth % 1000000007;
    }

    public static void power(long[][] A, long n) {
        if (n <= 1)
            return;

        power(A, n / 2);

        multiply(A, A);

        if (n % 2 == 1) // if n is odd
        {
            long[][] M = { { 1, 1 }, { 1, 0 } };
            multiply(A, M);
        }

    }

    public static long fib(long n) {
        long[][] A = { { 1, 1 }, { 1, 0 } };

        if (n == 0)
            return 0;

        power(A, n - 1);
        return A[0][0] % 1000000007;
    }

}