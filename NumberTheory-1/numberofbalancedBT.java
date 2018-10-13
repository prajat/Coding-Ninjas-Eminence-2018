import java.util.*;

/**
 * numberofbalancedBT
 */
public class numberofbalancedBT {

    public static void main(String[] args) {

        System.out.println(balancedTreesOfHeightH(4));
    }
    
    public static int balancedTreesOfHeightH(int height) {
       

        if (height <= 1) {
            return 1;
        }
        int mod = (int)Math.pow(10, 9) + 7;
        int x = balancedTreesOfHeightH(height - 1);
        int y = balancedTreesOfHeightH(height - 2);

        int value1 = (int) ((long) (x * x) % mod);
        int value2 = (int) ((long) (x * y * 2) % mod);
        
        int myans = (int)((long)value1 + value2) % mod;
        return myans;



    }
}