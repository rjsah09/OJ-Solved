import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];

        if (N == 1) {
            System.out.println(0);
            return;
        }
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                //System.out.println("j + num[j] = " + (numbers[j] + j) + ", i = " + i);
                if (numbers[j] + j >= i) {
                    if (i > 1 && j > 0 && dp[j] == 0) {
                        continue;
                    }

                    dp[i] = dp[i] == 0 ? dp[j] + 1 : Math.min(dp[j] + 1, dp[i]);
                }
            }
        }

        /*for (int i = 0; i < N; i++) {
            System.out.println(i + " : " + dp[i]);
        }*/

        int answer = dp[N - 1] == 0 ? -1 : dp[N - 1];
        System.out.println(answer);
    }
}