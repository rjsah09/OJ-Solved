import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        BigInteger numerator = BigInteger.ONE;   //분자
        BigInteger denominator = BigInteger.ONE;    //분모
        for (int i = 0; i < r; i++) {
            numerator = numerator.multiply(new BigInteger(Integer.toString(n - i)));
            denominator = denominator.multiply(new BigInteger(Integer.toString(i + 1)));

        }

        System.out.println(numerator.divide(denominator));
    }
}
