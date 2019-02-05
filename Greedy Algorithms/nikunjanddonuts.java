import java.util.*;

import java.util.Scanner;

public class nikunjanddonuts{

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();

        }

        Arrays.sort(arr);
        long miles = 0;
        long count = 1;
        for (int i = n - 1; i >= 0; i--) {
            miles += count * arr[i];
            count *= 2;
        }
          System.out.print(miles);

    }

}