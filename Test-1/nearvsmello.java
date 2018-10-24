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
        for (int i = height.length - 1; i >= 1; i--) {
            max += height[i] - height[i - 1];
        }
        System.out.println(max);
    }
}