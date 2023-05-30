import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(0);
            return;
        }

        int[][] jump = new int[N - 1][2];   //[n번째 돌][작은 점프 비용, 큰 점프 비용]
        for (int i = 0; i < N - 1; i++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            jump[i] = new int[] {
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            };
        }
        final int K = Integer.parseInt(br.readLine());

        int dp[][] = new int[N][N]; //[시작 돌][끝 돌]
        for (int i = 1; i < N; i++) {
            dp[i][i] = jump[i - 1][0];
            for (int j = i + 1; j < N; j++) {
                dp[i][j] = Math.min(dp[i][j - 1] + jump[j - 1][0], dp[i][j - 2] + jump[j - 2][1]);
            }
        }

        int answer = dp[1][N - 1];
        for (int i = 1; i + 2 < N; i++) {   //i = K의 시작 위치
            if (i + 3 >= N) {
                answer = Math.min(answer, dp[1][i - 1] + K);
            } else {
                answer = Math.min(answer, dp[1][i - 1] + K + dp[i + 3][N - 1]);
            }
        }
        System.out.println(answer);
    }
}