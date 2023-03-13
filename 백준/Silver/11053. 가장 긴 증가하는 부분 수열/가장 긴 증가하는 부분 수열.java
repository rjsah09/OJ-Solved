import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int size;
    static int[] sequences;
    static int[] dp;
    static int biggest;

    public static void main(String[] args) throws IOException {
        init();


        for (int i = 0; i <= size; i++) {
            dp[i] = 0;

            for (int j = 0; j < i; j++) {
                if (sequences[j] < sequences[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }

        }

        Arrays.sort(dp);
        System.out.println(dp[size]);
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        size = Integer.parseInt(line);
        sequences = new int[size + 1];
        dp = new int[size + 1];

        line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        for (int i = 1; i <= size; i++) {
            sequences[i] = Integer.parseInt(st.nextToken());
        }

        biggest = sequences[1];
    }

}