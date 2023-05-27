import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N + 1][N + 1];
        int[][] lineDP = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            line = br.readLine();
            st = new StringTokenizer(line);
            lineDP[i][1] = Integer.parseInt(st.nextToken());
            for (int j = 2; j <= N; j++) {
                lineDP[i][j] = lineDP[i][j - 1] + Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j <= N; j++) {
                dp[i][j] += dp[i - 1][j] + lineDP[i][j];
            }
        }

        for (int i = 0; i < M; i++) {
            line = br.readLine();
            st = new StringTokenizer(line);
            int[] start = new int[] {
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            };
            int[] end = new int[] {
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            };
            int answer = dp[end[0]][end[1]] - dp[start[0] - 1][end[1]] - dp[end[0]][start[1] - 1] + dp[start[0] - 1][start[1] - 1];
            System.out.println(answer);
        }
    }

    public static boolean isIdxSafe(int N, int idxI, int idxJ) {
        if (idxI < 0 || idxI >= N || idxJ < 0 || idxJ >= N) {
            return false;
        }

        return true;
    }
}