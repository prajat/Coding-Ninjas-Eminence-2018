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
            return 1;
        }
        int option1 = cost[i] + mincost(i + 1, man, cost, battle);
        //battle[2] += man[i];
        int battlecount = count(battle);
        if (battlecount > man[i]) {
            int[] mancount = modifiedbattlecount(battle, man[i]);
            int fightoption = mincost(i + 1, man, cost, mancount);

            return Math.min(option1, fightoption);

        } 
            // int[] battle2 = battle;
        // battle2[2] += man[i];
        battle[2] += man[i];
            int option2 = (2 * cost[i]) + mincost(i + 1, man, cost, battle);
            return Math.min(option1, option2);
        
        
        
        
        
        
        

        
            

    }

    public static int count(int[] battle) {
        int result = 0;
        for (int i = 0; i < battle.length; i++) {
            result += battle[i];
        }
        return result;

    }

    public static int[] modifiedbattlecount(int[] battle, int man) {
        
            for (int i = 0; i < battle.length; i++) {
                
            man = man - battle[i];
            if (man > 0) {
                battle[i] = 0;
            } else {
                battle[i] =(-1)*(man);
                }
            }
        
        //int a = battle[0];
        battle[0] = battle[1];
        battle[1] = battle[2];
        battle[2] = 0;
        return battle;

        
    }
    
}