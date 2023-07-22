import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String original = br.readLine();
            StringBuffer strBuffer = new StringBuffer(original);
            String reversed = strBuffer.reverse().toString();

            String sum = Integer.toString(Integer.parseInt(original) + Integer.parseInt(reversed));
            if (isSymemetry(sum)) {
                sb.append("YES" + "\n");
            } else {
                sb.append("NO" + "\n");
            }
        }

        System.out.println(sb);
    }

    static boolean isSymemetry(String sum) {
        for (int i = 0; i < sum.length() / 2; i++) {
            if (!sum.substring(i, i + 1).equals(sum.substring(sum.length() - 1 - i, sum.length() - i))) {
                return false;
            }
        }

        return true;
    }
}