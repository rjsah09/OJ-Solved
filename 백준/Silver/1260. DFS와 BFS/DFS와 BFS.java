import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //vertex
        int M = Integer.parseInt(st.nextToken());   //edge
        int V = Integer.parseInt(st.nextToken()) - 1;   //root node

        List<Integer> [] adjList = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken()) - 1;
            int vertex2 = Integer.parseInt(st.nextToken()) - 1;

            adjList[vertex1].add(vertex2);
            adjList[vertex2].add(vertex1);
        }

        for (int i = 0; i < adjList.length; i++) {
            Collections.sort(adjList[i]);
        }

        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[N];
        dfs(adjList, visited, V, sb);

        sb.append("\n");
        visited = new boolean[N];
        bfs(adjList, visited, V, sb);

        System.out.println(sb);
    }

    static void dfs(List<Integer>[] adjList, boolean[] visited, int index, StringBuilder sb) {
        visited[index] = true;
        sb.append((index + 1) + " ");

        for (int i = 0; i < adjList[index].size(); i++) {
            if (!visited[adjList[index].get(i)]) {
                dfs (adjList, visited, adjList[index].get(i), sb);
            }
        }
    }

    static void bfs(List<Integer>[] adjList, boolean[] visited, int index, StringBuilder sb) {
        Queue<Integer> bfsQ = new LinkedList<>();

        bfsQ.add(index);
        visited[index] = true;

        while (!bfsQ.isEmpty()) {
            int node = bfsQ.poll();
            visited[node] = true;
            sb.append((node + 1) + " ");

            for (int i = 0; i < adjList[node].size(); i++) {
                int next = adjList[node].get(i);
                if (!visited[next]) {
                    visited[next] = true;
                    bfsQ.add(next);
                }
            }
        }
    }
}
