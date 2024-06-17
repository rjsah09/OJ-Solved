import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int A;
    static int K;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] dp = new int[K + 1];

        dp[A] = 0;
        dp[A + 1] = 1;

        for (int i = A + 2; i <= K; i++) {
            if (A * 2 <= i && i % 2 == 0) {
                dp[i] = Math.min(dp[i / 2], dp[i - 1]);
                dp[i]++;
            } else {
                dp[i] = dp[i - 1] + 1;
            }
        }

        System.out.println(dp[K]);

    }
}
