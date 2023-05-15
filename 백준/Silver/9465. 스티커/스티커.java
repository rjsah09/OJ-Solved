import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int cases = Integer.parseInt(line);

        StringBuilder sb = new StringBuilder();
        for (int c = 0; c < cases; c++) {
            line = br.readLine();
            int col = Integer.parseInt(line);

            int[][] score = new int[2][col];
            for (int i = 0; i < 2; i++) {
                line = br.readLine();
                StringTokenizer st = new StringTokenizer(line);
                for (int j = 0; j < col; j++) {
                    score[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[2][col];

            dp[0][0] = score[0][0];
            dp[1][0] = score[1][0];

            if (score[0].length > 1) {
                dp[0][1] = score[1][0] + score[0][1];
                dp[1][1] = score[0][0] + score[1][1];
            }

            for (int i = 2; i < col; i++) {
                dp[0][i] = Math.max(Math.max(dp[0][i - 2], dp[1][i - 2]), dp[1][i - 1]) + score[0][i];
                dp[1][i] = Math.max(Math.max(dp[0][i - 2], dp[1][i - 2]), dp[0][i - 1]) + score[1][i];
            }

            int max = 0;
            for (int i = 0; i < col; i++) {
                max = Math.max(Math.max(dp[0][i], dp[1][i]), max);
            }

            sb.append(max + "\n");
        }

        System.out.println(sb);
    }
}