import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//22분
//10분
//10분


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //합의 결과 값 N
        int K = Integer.parseInt(st.nextToken());   //N을 이루는 수의 개수 K
        long[][] dp = new long[K + 1][N + 1]; //[숫자 k개][덧셈 결과 N]
        //dp[i][j] = dp[i - 1][j - l] //0부터 N까지 하나를 골라 더했을 때 j가 나와야 한다

        Arrays.fill(dp[1], 1);  //k가 1인 경우 1의 값만 가질 수 있다

        //마지막에 l을 더해서 K가 되었다 -> dp[K - 1][N - l];
        for (int i = 2; i <= K; i++) {           //숫자 i개를 더해서
            for (int j = 0; j <= N; j++) {       //결과가 0 ~ N이 되는 경우
                for (int l = 0; l <= j; l++) {     //마지막에 더할 숫자(l을 더해서 j가 되는 경우)
                    dp[i][j] += dp[i - 1][j - l] % 1_000_000_000L;
                }

                dp[i][j] %= 1_000_000_000;
            }
        }

        System.out.println(dp[K][N]);
    }
}
