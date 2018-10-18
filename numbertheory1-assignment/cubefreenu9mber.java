import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] arr = new int[1000001];
        for (int i = 2; i <= 100; i++) {
            {
                int c = i * i * i;
                for (int j = c; j < arr.length; j = j + c) {

                    arr[j] = -1;

                }
            }
        }
        int k = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != -1) {
                arr[i] = k;
                k++;
            }
        }

        int t = s.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = s.nextInt();
            if (arr[n] == -1) {
                System.out.println("Case " + i + ":" + " Not Cube Free");
            } else {
                System.out.println("Case " + i + ": " + arr[n]);
            }
        }
    }
}