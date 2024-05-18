import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N + 1][2];   //결과 값, 각 dp 값에 2를 더한 누적 합

        dp[1][0] = 2;
        dp[1][1] = 4;
        if (N >= 2) {
            dp[2][0] = 7;
            dp[2][1] = 18;
        }

        for (int i = 3; i <= N; i++) {  //벽이 2 * i인 경우
            dp[i][0] = (2 + dp[i - 1][0] * 2 + dp[i - 2][0] * 3 + dp[i - 3][1]) % 1_000_000_007;
            dp[i][1] = dp[i - 1][1] + dp[i][0] * 2;
        }

        /*for (int i = 1; i <= N; i++) {
            System.out.println(i + "일 때 : " + dp[i][0]);
        }*/

        System.out.println(dp[N][0]);
    }
}