import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] stats;
    static boolean[] visited;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int playerCount = 11;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            stats = new int[11][11];
            for (int j = 0; j < playerCount; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < playerCount; k++) {
                    stats[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            max = 0;
            visited = new boolean[playerCount];
            for (int j = 0; j < playerCount; j++) {
                if (stats[j][0] > 0) {
                    dfs(j, 0, stats[j][0]);
                }
            }

            sb.append(max + "\n");
        }

        System.out.println(sb);
    }

    static void dfs(int player, int position, int score) {
        visited[player] = true;

        if (position == stats.length - 1) {
            max = Math.max(max, score);
            visited[player] = false;
            return;
        }

        for (int i = 0; i < stats.length; i++) {
            if (!visited[i] && stats[i][position + 1] > 0) {
                dfs(i, position + 1, score + stats[i][position + 1]);
            }
        }

        visited[player] = false;
    }
}
