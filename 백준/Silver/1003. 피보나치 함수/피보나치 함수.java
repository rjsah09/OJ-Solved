import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] testCases = new int[T];
        for (int i = 0; i < T; i++) {
            testCases[i] = Integer.parseInt(br.readLine());
        }
        int max = Arrays.stream(testCases).max().getAsInt();

        int[][] dp = new int[max + 1][2];
        dp[0][0] = 1;
        if (max >= 1) {
            dp[1][1] = 1;
        }
        
        for (int i = 2; i <= max; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testCases.length; i++) {
            int N = testCases[i];
            sb.append(dp[N][0] + " " + dp[N][1]).append("\n");
        }

        System.out.println(sb);
    }
}
