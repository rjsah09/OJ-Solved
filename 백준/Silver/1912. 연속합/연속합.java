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
        //값이 -가 아닌 이상, 무조건 더하는 것이 이득
        //지금까지 더해온 값에 현재 값을 더하는 것과, 현재 값을 비교해서 이득인 것을 취함
        //ex) 이전까지 더한 값이 -300이고, 현재 값이 3인 경우, 이전 값을 버리고 현재 값을 취하는 것이 옳은 선택이다.
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            if (i == 1) {
                dp[i] = answer = num[i];
            } else {
                dp[i] = Math.max(dp[i - 1] + num[i], num[i]);
                answer = Math.max(dp[i], answer);
            }
        }

        System.out.println(answer);
    }
}
