import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][10];

        Arrays.fill(dp[1], 1);
        for (int i = 2; i <= N; i++) {  //i번째 자리가

            for (int j = 0; j < 10; j++) { //j로 끝나는 경우
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i - 1][k] % 10_007;
                }

                dp[i][j] %= 10_007;
            }
        }

        int result = 0;
        for (int i = 0; i < 10; i++) {
            result += dp[N][i] % 10_007;
        }
        result %= 10_007;

        System.out.println(result);
    }
}