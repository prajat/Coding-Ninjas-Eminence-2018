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
        int startindex = s.nextInt();
        int endindex = s.nextInt();

        boolean[] visited = new boolean[V];
        System.out.println(haspathdfs(edges, startindex, endindex, visited));
    }

    public static boolean haspathdfs(int[][] edges, int startindex, int endindex, boolean[] visited) {
        if (edges[startindex][endindex] == 1 || startindex == endindex) {
            return true;
        }

        visited[startindex] = true;
        for (int i = 0; i < edges.length; i++) {

            if (edges[startindex][i] == 1) {
                if (visited[i] != true) {
                    if (haspathdfs(edges, i, endindex, visited) == true)
                        return true;

                }
            }

        }

        return false;

    }
}