import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<Integer>[] adjList;
    static boolean[] visited;
    static int[] hackable;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //edge
        int M = Integer.parseInt(st.nextToken());   //vertex

        adjList = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int connected = Integer.parseInt(st.nextToken()) - 1;
            int node = Integer.parseInt(st.nextToken()) - 1;

            adjList[connected].add(node);
        }

        hackable = new int[N];
        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            bfs(i);
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, hackable[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (hackable[i] == max) {
                sb.append((i + 1) + " ");
            }
        }

        System.out.println(sb);
    }

    static void bfs(int startNode) {
        Queue<Integer> q = new LinkedList<>();
        q.add(startNode);
        visited[startNode] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int next : adjList[node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    hackable[next]++;
                }
            }
        }

    }
}
