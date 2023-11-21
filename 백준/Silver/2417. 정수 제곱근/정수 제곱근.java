import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger n = new BigInteger(br.readLine());
        BigInteger q = n;

        BigInteger start = new BigInteger("0");
        BigInteger end = q;

        while (start.compareTo(end) <= 0) {
            BigInteger center = start.add(end).divide(new BigInteger("2"));
            BigInteger centerAbs = center.abs();

            if (centerAbs.multiply(centerAbs).compareTo(n) >= 0) {
                q = centerAbs;
                end = centerAbs.subtract(new BigInteger("1"));
            } else {
                start = centerAbs.add(new BigInteger("1"));
            }
        }

        System.out.println(q);
    }
}
