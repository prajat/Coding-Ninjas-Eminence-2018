import java.util.*;
/**
 * stockspan
 */
public class stockspan {

    public static void main(String[] args) {

        int price[] = {1,1,1,1};
        int[] arr = stockSpan(price);
        for (int i : arr) {
            System.out.println(i);
        }

    }
    
    public static int[] stockSpan(int[] price) {
        // Write your code here

        int[] span = new int[price.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);;
        span[0] = 1;
        for (int i = 1; i < price.length; i++) {
            while (!stack.isEmpty() && price[stack.peek()] < price[i])
                stack.pop();

            span[i] = (stack.isEmpty()) ? (i + 1) : (i - stack.peek());
            stack.push(i);

        }
        
        return span;

    }
}