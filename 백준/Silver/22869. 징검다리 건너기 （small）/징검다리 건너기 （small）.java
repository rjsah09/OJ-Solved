import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static int[] powers;
    static boolean[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        powers = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            powers[i] = Integer.parseInt(st.nextToken());
        }

        dp = new boolean[N];  //가장 많은 잔여 에너지
        dp[0] = true;

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {   //시작점
                if (!dp[j]) {
                    continue;
                }
                
                int required = getRequiredPower(j, i);
                if (required <= K) {
                    dp[i] = true;
                }
            }
        }

        /*for (int i = 0; i < N; i++) {
            System.out.println(dp[i]);
        }*/
        String result = dp[N - 1] ? "YES" : "NO";
        System.out.println(result);
    }

    static int getRequiredPower(int start, int end) {
        return (end - start) * (1 + Math.abs(powers[start] - powers[end]));
    }
}