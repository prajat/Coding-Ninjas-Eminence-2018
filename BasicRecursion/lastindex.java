import java.util.*;
/**
 * lastindex
 */
public class lastindex {

    
    public static int lastIndex(int input[], int x) {
        return index(input, 0, x);
    }

    public static int index(int[] input, int starti, int x) {
        if (starti == input.length) {
            return -1;
        }

        int smallans = index(input, starti + 1, x);
        if (ans != -1) {
            return smallans;
        }
        if (input[starti] == x) {
            return starti;
        }
        else {
            return -1;
        }
        
    }
}