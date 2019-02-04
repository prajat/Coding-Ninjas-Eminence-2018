import java.util.*;


public class Min._Absolute Difference In Array {

    public static int minAbsoluteDifference(int input[]) {
        Arrays.sort(input);
        int min=Integer.MAX_VALUE;
        for(int i=0;i<input.length-1;i++){
            int diff=Math.abs(input[i]-input[i+1]);
            if(diff<min){
                min=diff;
            }


        }
        return min;
	}
}


