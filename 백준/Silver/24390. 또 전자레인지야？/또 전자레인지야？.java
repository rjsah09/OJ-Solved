import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), ":");
        int time = (Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken())) / 10;

        //2번째 인덱스가 0 : 아직 시작 버튼을 누르지 않은 경우
        //2번쨰 인덱스가 1 : 시작 버튼이 눌린 경우 -> 시작 버튼을 누르는 경우도 포함한다
        int[][] dp = new int[time + 1][2];
        dp[0][1] = 1;
        if (time >= 1) {
            dp[1][1] = 2;
        }
        if (time >= 2) {
            dp[2][1] = 3;
        }
        if (time >= 3) {
            dp[3][1] = 1;
        }
        if (time >= 6) {
            dp[6][1] = 2;
        }

        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = dp[i - 1][0] + 1;

            if (i >= 4) {
                dp[i][1] = dp[i - 1][1] + 1;
            }

            if (i >= 6) {
                dp[i][0] = Math.min(dp[i - 6][0] + 1, dp[i][0]);
                dp[i][1] = Math.min(dp[i - 6][1] + 1, dp[i][1]);
            }

            if (i >= 60) {
                dp[i][0] = Math.min(dp[i - 60][0] + 1, dp[i][0]);
                dp[i][1] = Math.min(dp[i - 60][1] + 1, dp[i][1]);
            }
        }

        /*for (int i = 0; i < time + 1; i++) {
            System.out.println(i + " [0]: " + dp[i][0] + ", [1]: " + dp[i][1]);
        }*/

        System.out.println(Math.min(dp[time][1], dp[time][0] + 1));
    }
}