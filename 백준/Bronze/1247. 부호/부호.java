import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            int N = Integer.parseInt(br.readLine());

            BigInteger sum = new BigInteger("0");
            for (int j = 0; j < N; j++) {
                sum = sum.add(new BigInteger(br.readLine()));
            }

            BigInteger zero = new BigInteger("0");
            int compared = sum.compareTo(zero);

            if (compared == 0) {
                sb.append("0");
            } else if (compared > 0) {
                sb.append("+");
            } else {
                sb.append("-");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}