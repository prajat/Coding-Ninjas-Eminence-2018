import java.util.*;
/**
 * dfsimplementation
 */
public class dfsimplementation {

    public static void main(String[] args) {


        int n = 4;
        int[][] edges = new int[4][4];
        edges[0][2] = 1;
        edges[2][0] = 1;
        edges[2][1] = 1;
        edges[1][2] = 1;
        edges[1][3] = 1;
        edges[3][1] = 1;
        boolean[] visited = new boolean[n];
        dfs(edges, n, 0, visited);

    }

    public static void dfs(int[][] edges, int n, int start, boolean[] visited) {
        System.out.println(start);
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
