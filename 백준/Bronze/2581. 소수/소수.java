import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        boolean[] primeChecker = new boolean[N + 1];
        primeChecker[0] = primeChecker[1] = true;

        for (int i = 0; i < primeChecker.length; i++) {
            if (primeChecker[i]) {
                continue;
            }

            for (int j = 2; i * j < primeChecker.length; j++) {
                primeChecker[i * j] = true;
            }
        }

        int min = Integer.MAX_VALUE;
        int sum = 0;

        for (int i = M; i < primeChecker.length; i++) {
            if (!primeChecker[i]) {
                min = Math.min(min, i);
                sum += i;
            }
        }

        if (sum  == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
