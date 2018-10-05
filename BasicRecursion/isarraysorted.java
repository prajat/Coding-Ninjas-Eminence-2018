import java.util.*;
/**
 * isarraysorted
 */
public class isarraysorted {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 5 };
        System.out.println(issorted(arr, 0, arr.length));

    }

    public static boolean issorted(int[] arr, int starti, int size) {
        if(size==1||size==0)
        {
            return true;
        }
        if (arr[starti] > arr[starti + 1]) {
            return false;
        }
        boolean issortedsmall = issorted(arr, starti + 1, size - 1);

        return issortedsmall;
        
        
    }
}
