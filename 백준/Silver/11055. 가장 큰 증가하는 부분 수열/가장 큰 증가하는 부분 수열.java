import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int n = Integer.parseInt(line);
        int[] num = new int[n + 1];
        int[] dp = new int[n + 1];

        line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        for (int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = num[1];
        for (int i = 2; i <= n; i++) {
            for (int j = 0 ; j < i; j++) {
                if (num[j] < num[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + num[i]);
                }
            }
        }

        int answer = 0;
        for (int i = 1; i < dp.length; i++) {
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }
}