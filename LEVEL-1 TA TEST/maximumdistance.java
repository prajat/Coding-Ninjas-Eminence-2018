import java.util.*;

/*
	- You are given an integer array, that can contain duplicate elements.
	- You have to return the maximum possible distance between two repeating elements having same value.

	- For example :-
		arr = [1, 3, 1, 4, 5, 6, 4, 8, 3];
		
		index0 = 1
		index1 = 3
		index2 = 1
		index3 = 4
		index4 = 5
		index5 = 6
		index6 = 4
		index7 = 8
		index8 = 3
		
		In the above array, the repeating elements are :- (1, 3, 4)
		- Distance bw first and last occurence of 1 = 2(index2 - index0)
		- Distance bw first and last occurence of 3 = 7(index8 - index1)
		- Distance bw first and last occurence of 4 = 3(index6 - index3)

		So, for the above array you must return 7, as this is maximum possible distance between two repeating elements having same value.

	- If there are no duplicate elements in the array, return 0.

*/

public class solution {
    public static int maxDistance(int arr[]) {
        // write your code here.

        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], i);
            }
            max = Math.max(max, i - map.get(arr[i]));
        }
        





        return max;
    }
}
