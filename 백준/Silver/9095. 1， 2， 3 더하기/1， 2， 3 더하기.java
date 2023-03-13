import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> testCase = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            testCase.add(Integer.parseInt(br.readLine()));
        }
        int[] dp = new int[12];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i = 4; i <= 11; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];  //1을 더해야하는 경우 + 2를 더야해야하는 경우 + 3을 더해야하는 경우
        }

        for(int i = 0; i < n; i++)
            System.out.println(dp[testCase.get(i)]);
    }
}
