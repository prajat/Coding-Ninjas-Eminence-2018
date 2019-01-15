
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

        bfs(edges, V, 0, visited);

    }

    public static void bfs(int[][] edges, int V, int start, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int front = queue.poll();
            System.out.print(front+" ");
            for (int i = 0; i < V; i++) {
                if (edges[front][i] == 1 && visited[i]!= true) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        
    }
}