import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[] weightTools;
    static boolean[] visited;

    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        weightTools = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weightTools[i] = Integer.parseInt(st.nextToken());
        }

        result  = 0;
        for (int i = 0; i < N; i++) {
            dfs(1, 500 - K + weightTools[i], i);
        }

        System.out.println(result);
    }

    static void dfs(int depth, int weightAmount, int node) {
        visited[node] = true;

        if (weightAmount < 500) {
            visited[node] = false;
            return;
        }

        if (depth == N) {
            result++;
            visited[node] = false;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                dfs(depth + 1, weightAmount - K + weightTools[i], i);
            }
        }

        visited[node] = false;
    }
}
