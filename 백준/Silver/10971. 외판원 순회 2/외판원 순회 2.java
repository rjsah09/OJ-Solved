import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static boolean[] visited;
    static int[][] adj;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input =  br.readLine();
        n = Integer.parseInt(input);
        visited = new boolean[n];
        adj = new int[n][n];

        for(int i = 0; i < n; i++) {
            input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            for(int j = 0; j < n; j++)
                adj[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++) {
            dfs(i, i, i, 0, 0);
        }

        System.out.println(answer);
    }

    static void dfs(int dest, int prev, int now, int sum, int cnt) {
        visited[now] = true;
        sum += adj[prev][now];
        
        if(sum >= answer) {
            visited[now] = false;
            return;
        }

        if(cnt == n - 1) {
            if(adj[now][dest] > 0) {
                sum += adj[now][dest];
                answer = Math.min(answer, sum);
            }
            visited[now] = false;
            return;
        }

        for(int i = 0; i < n; i++) {
            if(!visited[i] && adj[now][i] > 0) dfs(dest, now, i, sum, cnt + 1);
        }

        visited[now] = false;
    }
}
