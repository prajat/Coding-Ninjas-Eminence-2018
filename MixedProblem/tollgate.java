import java.util.*;
/**
 * tollgate
 */
public class tollgate {

    public static void main(String[] args) {
        // Scanner s = new Scanner(System.in);
        // int n = s.nextInt();
        // int[] man = new int[n];
        // int[] cost = new int[n];

        // int k = 0;
        // for (int i = 1; i <= n; i++) {
        //     man[k] = s.nextInt();
        //     cost[k] = s.nextInt();

        //     k++;
        // }
        // int[] battle = new int[3];

        int[] man = { 10, 70, 80, 20, 50, 30, 10 };
        int[] cost = { 100, 5, 15, 60, 90, 80, 10 };
        int[] battle = { 0, 0, 0 };
        System.out.println(mincost(0,man, cost, battle));
    }

    public static int mincost(int i, int[] man, int[] cost, int[] battle) {
        if (i == man.length) {
            return 0;
        }
        int option1 = cost[i] + mincost(i + 1, man, cost, battle);
        //battle[2] += man[i];
        int fightoption = Integer.MAX_VALUE;
        int battlecount = count(battle);
        if (battlecount > man[i]) {
            int[] mancount = modifiedbattlecount(battle, man[i]);
            fightoption = mincost(i + 1, man, cost, mancount);

            

        } 
        
       battle[2] += man[i];
        int option2 = (2 * cost[i]) + mincost(i + 1, man, cost, battle);
            battle[2] -= man[i];
            return Math.min(option1, Math.min(fightoption, option2));
        
        
        
        
        
        
        

        
            

    }

    public static int count(int[] battle) {
        int result = 0;
        for (int i = 0; i < battle.length; i++) {
            result += battle[i];
        }
        return result;

    }

    public static int[] modifiedbattlecount(int[] battle, int x) {
        
        
        int[] updated_men = new int[3];
        for (int k = 0; k < 3; k++)
            updated_men[k] = battle[k];

        for (int k = 0; k < 3; k++) {
            if (x <= updated_men[k] && x >= 0) {
                updated_men[k] -= x;
                break;
            } else {
                x = x - updated_men[k];
                updated_men[k] = 0;
            }
        }
        updated_men[0] = updated_men[1];
        updated_men[1] = updated_men[2];
        updated_men[2] = 0;
        return updated_men;

        
    }
    
}