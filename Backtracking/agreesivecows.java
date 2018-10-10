import java.util.*;

/**
 * agreesivecows
 */
public class agreesivecows {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 1; i <= t; i++) {
            int n=s.nextInt();
            int c=s.nextInt();
            long[] positions=new int[n];
            for(int j=0;j<n;j++){
                positions[j]=s.nextLong();
            }
            Arrays.sort(positions);
            long start=0;
        long end=positions[n-1]-positions[0];
        long ans=-1;
        while(start<=end){
            long mid=start+(end-start)/2;
            if(check(c,positions,mid)){
                ans=mid;
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        }
        System.out.println(ans);
        
    }

    public static boolean check(int c, long[] positions, long distance) {
        int count = 1;
        long lastpositions = positions[0];
        for (int i = 0; i < positions.length; i++) {
            if ( positions[i]-lastpositions >= distance) {
                lastpositions = positions[i];
                count++;
            }
            if (count == c) {
                return true;

            }
        }
        return false;
        
    }
}