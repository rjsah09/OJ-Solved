import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    static boolean[] primes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        primes = new boolean[1003002]; //1000001까지
        Arrays.fill(primes, true);

        //에라토스테네스의 체
        primes[0] = false;
        primes[1] = false;
        for (int i = 2; i < primes.length; i++) {
            if (!primes[i]) {
                continue;
            }

            for (int j = 2; i * j < primes.length; j++) {
                primes[i * j] = false;
            }
        }

        for (int i = N; i < primes.length; i++) {
            if (primes[i] && isPalindrome(i)) {
                System.out.println(i);
                return;
            }
        }
    }

    public static boolean isPalindrome(int number) {
        String origin = Integer.toString(number);
        String reversed = new StringBuffer(origin).reverse().toString();

        return origin.equals(reversed);
    }
}
