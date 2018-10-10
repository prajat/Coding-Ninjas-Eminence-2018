import java.util.*;
/**
 * power
 */
public class power {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        int n = s.nextInt();

        
        System.out.println(powerfn(x, n));
        
    }
    public static int powerfn(int x,int y) {
        if(y==1)
        {
            return x;
        }
        return x*powerfn(x, y-1);
        
    }
    
}