import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double[] dp  = new double[N];

        double max = 0;
        for (int i = 0; i < N; i++) {
            double number = Double.parseDouble(br.readLine());

            if (i == 0) {
                max = number;
                dp[0] = number;
                continue;
            }

            dp[i] = Math.max(dp[i - 1] * number, number);
            max = Math.max(dp[i], max);
        }

        System.out.printf("%.3f%n", max);
    }
}
