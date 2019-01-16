import java.util.Scanner;

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
        dfs(edges, V, 0, visited);
        boolean ans = true;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == false) {
                ans = false;
                break;

            }
        }
        System.out.print(ans);

    }

    public static void dfs(int[][] edges, int n, int start, boolean[] visited) {

        visited[start] = true;
        for (int i = 0; i < n; i++) {
            if (i == start) {
                continue;
            }
            if (edges[start][i] == 1) {
                if (visited[i] != true) {
                    dfs(edges, n, i, visited);

                }
            }
        }

    }
}