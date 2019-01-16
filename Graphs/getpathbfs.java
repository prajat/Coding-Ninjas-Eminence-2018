import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;
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

        ArrayList<Integer> list = getpathbfs(edges, startindex, endindex, visited);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }

    public static ArrayList<Integer> getpathbfs(int[][] edges, int startindex, int endindex, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();

        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        queue.add(startindex);
        visited[startindex] = true;
        int flag = 0;
        while (!queue.isEmpty()) {
            int front = queue.poll();
            for (int i = 0; i < edges.length; i++) {
                if (edges[front][i] == 1 && visited[i] != true) {
                    queue.add(i);
                    visited[i] = true;
                    map.put(i, front);
                    if (i == endindex) {
                        flag = 1;
                        break;
                    }
                }
            }
        }
        if (flag == 0) {
            return new ArrayList();
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(endindex);
        int x = endindex;
        while (x != startindex) {
            list.add(map.get(x));
            x = map.get(x);
        }

        return list;

    }
}