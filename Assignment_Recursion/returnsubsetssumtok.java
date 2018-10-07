import java.util.*;
/**
 * returnsubsetssumtok
 */
public class returnsubsetssumtok {

    public static void main(String[] args) {

    }
    
    public static int[][] subsetsSumK(int input[], int p) {
        // Write your code here
        return subsetsSumK(input, p, 0);

    }

    public static int[][] subsetsSumK(int[] input, int p, int start) {
        if (start == input.length) {
            if (p == 0) {
                return new int[1][0];
            }
            else {
                return new int[0][0];
            }
        }
        int cn=input[start];
        int[][] smallans1=subsetsSumK(input, p,start+1);
        int[][] smallans2=subsetsSumK(input, p-cn, start+1);
        
        int[][] myans=new int[smallans1.length+smallans2.length][];
        int k=0;
        for(int i=0;i<smallans1.length;i++){
            myans[k]=smallans1[i];
            k++;
            
        }
        for(int i=0;i<smallans2.length;i++){
            myans[k]=new int[smallans2[i].length+1];
            myans[k][0]=cn;
            for(int j=0;j<smallans2[i].length;j++){
                myans[k][j+1]=smallans2[i][j];
            }
            k++;
        }
        return myans;
        
    }
    
    
}