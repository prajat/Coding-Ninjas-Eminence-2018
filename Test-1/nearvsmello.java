import java.util.*;

/**
 * nearvsmello
 */
public class nearvsmello {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int[] height = new int[n];
        for (int i = 0; i < height.length; i++) {
            height[i] = s.nextInt();

        }
        int max = 0;
        Arrays.sort(height);
        for (int i = 0; i < n - 2; i++) {
            max += height[n - 2] - height[i];
        }

        System.out.println(max);
    }
}