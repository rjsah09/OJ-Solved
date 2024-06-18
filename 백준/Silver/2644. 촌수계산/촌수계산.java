import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//08:59 ~ 09:00
//09:51 ~ 10:00
//10:51 ~

public class Main {

    static int N;
    static int M;
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    static int one;
    static int other;
    static int kinship;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        one = Integer.parseInt(st.nextToken()) - 1;
        other = Integer.parseInt(st.nextToken()) - 1;
        M = Integer.parseInt(br.readLine());
        visited=  new boolean[N];
        kinship = -1;

        //인접 리스트 생성
        adjList = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
        }

        //인접 리스트 채우기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken()) - 1;
            int child = Integer.parseInt(st.nextToken()) - 1;

            adjList[child].add(parent);
            adjList[parent].add(child);
        }

        //dfs 탐색
        dfs(one, 0);

        System.out.println(kinship);
    }

    static void dfs(int node, int depth) {
        visited[node] = true;

        if (node == other) {
            kinship = depth;
        }

        for (int nextNode: adjList[node]) {
            if (!visited[nextNode]) {
                dfs(nextNode, depth + 1);
            }
        }
    }
}
