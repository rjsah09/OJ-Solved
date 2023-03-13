import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];

        for(int i = 1; i * i <= n; i++) {
            dp[i * i] = 1;
        }

        if(n >= 2) {
            for (int i = 2; i <= n; i++) {
                if(dp[i] == 1) continue;

                for(int j = 1; j * j <= i; j++) {
                    if(dp[i] == 0) dp[i] = dp[j * j] + dp[i - j * j];
                    else dp[i] = Math.min(dp[i],dp[j * j] + dp[i - j * j]);
                }
            }
        }

        System.out.println(dp[n]);
    }
}