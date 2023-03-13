import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < n - 1; i++) {
            int n1 = in.nextInt() - 1;
            int n2 = in.nextInt() - 1;
            adj.get(n1).add(n2);
            adj.get(n2).add(n1);
        }

        bfs(n);
    }

    static void bfs(int nodes) {
        boolean[] visited = new boolean[nodes];
        int[] parent = new int[nodes - 1];
        Queue<Integer> q = new LinkedList<>();

        q.offer(0);
        while(!q.isEmpty()) {
            int node = q.poll();
            visited[node] = true;
            for(int i = 0; i < adj.get(node).size(); i++) {
                if(!visited[adj.get(node).get(i)] && node != adj.get(node).get(i)) {
                    q.add(adj.get(node).get(i));
                    parent[adj.get(node).get(i) - 1] = node + 1;
                }
            }
        }

        for(int num : parent) {
            System.out.println(num);
        }
    }
}