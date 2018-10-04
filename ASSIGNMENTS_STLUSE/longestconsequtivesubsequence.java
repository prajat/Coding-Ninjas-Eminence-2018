import java.util.*;
/**
 * longestconsequtivesubsequence
 */
public class longestconsequtivesubsequence {

    public static void main(String[] args) {
        //int[] arr = { 2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6 };
        //int[] arr = { 15, 13, 23, 21, 19, 11, 16 };
        int[] arr = { 1, 9, 3, 10, 4, 20, 2 };
        ArrayList<Integer> list = longestSubsequence(arr);
        System.out.print(list+" ");

    }
    public static ArrayList<Integer> longestSubsequence(int[] arr){
        // Write your code here
        ArrayList<Integer> list = new ArrayList<>();

        int maxlength = 0;
        int start = 0;
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], true);

        }
        
        

        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) == true) {
                // startc = arr[i];
                int startc = arr[i];
                int lengthc = 1;
                int k = arr[i]+1;
                int l = arr[i]-1;
                while (map.containsKey(k )) {
                    lengthc++;
                    map.put(k, false);
                    k++;
                }
                while (map.containsKey(l)) {
                    lengthc++;
                    map.put(l, false);
                    startc = l;
                    l--;

                }
                if (lengthc > maxlength) {
                    maxlength = lengthc;
                    start = startc;
                }

            }
            
            
        }
        for (int i = start; i <start + maxlength; i++) {
            list.add(i);
        }
        return list;
        

	}

}