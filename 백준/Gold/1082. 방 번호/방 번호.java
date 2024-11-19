import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] P = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String[] dp = new String[M + 1];
        Arrays.fill(dp, "0");

        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
            if (dp.length > P[i]) {
                dp[P[i]] = Integer.toString(i);
            }
        }

        for (int i = 0; i <= M; i++) {  //돈이 i인 경우
            for (int j = 0; j < P.length; j++) {  //j번째 번호를 마지막으로 구매하는 경우
                if (i - P[j] >= 0) {    //가진 돈이 i 이상인 경우
                   String value = dp[i - P[j]].equals("0") ? Integer.toString(j) : toMaxValue(dp[i - P[j]] + j);
                   dp[i] = new BigInteger(dp[i]).compareTo(new BigInteger(value)) >= 0 ? dp[i] : value;
                }
            }
        }

        System.out.println(dp[M]);
    }

    static String toMaxValue(String value) {
        Character[] chars = new Character[value.length()];
        for (int i = 0; i < value.length(); i++) {
            chars[i] = value.charAt(i);
        }

        Arrays.sort(chars, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder(chars.length);
        for (Character c : chars) {
            sb.append(c);
        }

        return removeZero(sb.toString());
    }

    static String removeZero(String value) {
        while (value.charAt(0) == '0') {
            value = value.replace("0", "");

            if (value.isEmpty()) {
                return "0";
            }
        }

        return value;
    }
}
