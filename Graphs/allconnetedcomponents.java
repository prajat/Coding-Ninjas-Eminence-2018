import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int V = s.nextInt();
        int E = s.nextInt();
        int[][] edges = new int[V][V];
        for (int i = 0; i < E; i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            edges[a][b] = 1;
            edges[b][a] = 1;

        }

        boolean[] visited = new boolean[V];

        ArrayList<ArrayList<Integer>> output = new ArrayList<>();

        for (int i = 0; i < visited.length; i++) {
            if (visited[i] != true) {
                ArrayList<Integer> smallans = new ArrayList<>();
                dfs(edges, edges.length, i, visited, smallans);
                output.add(smallans);

            }
        }
        for (int i = 0; i < output.size(); i++) {
            Collections.sort(output.get(i));
        }
        for (int i = 0; i < output.size(); i++) {
            for (int j = 0; j < output.get(i).size(); j++) {
                System.out.print(output.get(i).get(j) + " ");
            }
            System.out.println();
        }

    }

    public static void dfs(int[][] edges, int n, int start, boolean[] visited, ArrayList<Integer> list) {

        list.add(start);
        visited[start] = true;
        for (int i = 0; i < n; i++) {
            if (i == start) {
                continue;
            }
            if (edges[start][i] == 1) {
                if (visited[i] != true) {
                    dfs(edges, n, i, visited, list);

                }
            }
        }

    }
}
