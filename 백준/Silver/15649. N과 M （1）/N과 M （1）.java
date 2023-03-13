import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static boolean[] visited;
    static int[] list;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new int[m];
        visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            dfs(i, 1);
        }

        System.out.println(sb);
    }

    static void dfs(int node, int depth) {
        visited[node] = true;
        list[depth - 1] = node + 1;

        if(depth == m) {
            for(int i = 0; i < m; i++)
                sb.append(list[i] + " ");
            sb.append("\n");
            visited[node] = false;
            return;
        }

        for(int i = 0; i < n; i++) {
            if(!visited[i])
                dfs(i, depth + 1);
        }

        visited[node] = false;
    }
}