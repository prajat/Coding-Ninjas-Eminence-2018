import java.util.*;

/**
 * knapsackrecursive
 */
public class knapsackdp {

    public static void main(String[] args) {
        int[] value = { 60, 100, 120 };
        int[] weight = { 10, 20, 30 };
        int maxWeight = 50;
        System.out.println(knapsack(weight, value, maxWeight));
    }

    public static int knapsack(int[] weight, int value[], int maxWeight) {

        int[][] storage = new int[value.length+1][maxWeight+1];
        return knapsack(weight, value, maxWeight, 0,storage);

    }

    public static int knapsack(int[] weight, int value[], int maxWeight, int start, int[][] storage) {

        if (storage[start][maxWeight] > 0) {
            return storage[start][maxWeight];
        }

        if (start == weight.length || maxWeight == 0) {

            storage[start][maxWeight] = 0;
            return storage[start][maxWeight];
        }
        if (weight[start] > maxWeight) {
            storage[start][maxWeight] = knapsack(weight, value, maxWeight, start + 1, storage);
            return storage[start][maxWeight];
        } else {
            int op1 = value[start] + knapsack(weight, value, maxWeight - weight[start], start + 1, storage);
            int op2 = knapsack(weight, value, maxWeight, start + 1, storage);
            storage[start][maxWeight] = Math.max(op1, op2);
            return storage[start][maxWeight];

        }

    }
    
}