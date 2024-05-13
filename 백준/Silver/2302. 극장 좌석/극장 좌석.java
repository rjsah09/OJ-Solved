import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //좌석 수
        int M = Integer.parseInt(br.readLine());    //VIP 수

        /*
        * [해결방법]
        * 점화식을 도출하면 f(i) = f(i - 1) + f(i - 2)의 결과가 나온다
        * vip 석을 기준으로 구역을 구분해 각 구역의 가능한 경우의 수를 곱해 결과를 얻을 수 있다
        * */

        int[] dp = new int[41];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        //점화식
        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        
        int result = 1; //결과 값은 곱셈으로 이루어지므로 1부터 시작해야한다
        int before = 0; //이전 위치
        for (int i = 0; i < M; i++) {
            int vip = Integer.parseInt(br.readLine());
            result *= dp[vip - before - 1];
            before = vip;
        }
        result *= dp[N - before];

        System.out.println(result);

    }
}