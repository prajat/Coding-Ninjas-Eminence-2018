import java.util.ArrayList;
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

        ArrayList<Integer> list = dfs(edges, startindex, endindex, visited);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");

        }
    }

    public static ArrayList<Integer> dfs(int[][] edges, int startindex, int endindex, boolean[] visited) {
        if (startindex == endindex) {

            ArrayList<Integer> list = new ArrayList<>();
            list.add(endindex);
            return list;
        }

        visited[startindex] = true;
        for (int i = 0; i < edges.length; i++) {
            if (edges[startindex][i] == 1 && visited[i] != true) {
                if (haspathdfs(edges, i, endindex, visited) == true) {
                    ArrayList<Integer> smalllist = dfs(edges, i, endindex, visited, list);
                    if (smalllist.size() > 0) {
                        smalllist.add(startindex);
                        return smalllist;
                    }

                }

            }
        }
        return new ArrayList();

    }

}