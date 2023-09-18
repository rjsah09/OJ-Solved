import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];

        sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            dfs(1, "", i);
        }

        System.out.println(sb);
    }

    static void dfs(int depth, String prev, int n) {
        visited[n] = true;
        prev += n + " ";

        if (depth == N) {
            sb.append(prev + "\n");
            visited[n] = false;
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(depth + 1, prev, i);
            }
        }

        visited[n] = false;
    }
}
