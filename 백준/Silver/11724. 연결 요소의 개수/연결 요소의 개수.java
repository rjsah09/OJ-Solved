import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] adjList;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int vertexCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[vertexCount];
        visited = new boolean[vertexCount];

        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken()) - 1;
            int v2 = Integer.parseInt(st.nextToken()) - 1;
            connect(v1, v2);
        }

        int componentCount = 0;
        for (int i = 0; i < adjList.length; i++) {
            if (!visited[i]) {
                bfs(i);
                componentCount++;
            }
        }

        System.out.println(componentCount);

    }

    static void connect(int v1, int v2) {
        adjList[v1].add(v2);
        adjList[v2].add(v1);
    }

    static void bfs(int startNode) {
        Queue<Integer> q = new LinkedList<>();
        q.add(startNode);
        visited[startNode] = true;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next: adjList[now]) {
                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}
