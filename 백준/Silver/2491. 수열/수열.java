import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[N];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N][2];
        int max = 1;
        dp[0][0] = dp[0][1] = 1;
        for (int i = 1; i < N; i++) {
            if (numbers[i] >= numbers[i - 1]) {
                dp[i][0] = dp[i - 1][0] + 1;
            } else {
                dp[i][0] = 1;
            }

            if (numbers[i] <= numbers[i - 1]) {
                dp[i][1] = dp[i - 1][1] + 1;
            } else {
                dp[i][1] = 1;
            }

            max = Math.max(Math.max(dp[i][0], dp[i][1]), max);
        }

        System.out.println(max);
    }
}
