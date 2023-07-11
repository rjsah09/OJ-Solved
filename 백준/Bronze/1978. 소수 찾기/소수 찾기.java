import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int answer = 0;
        boolean[] notPrime = new boolean[1001];
        notPrime[0] = notPrime[1] = true;
        for (int i = 0; i < notPrime.length; i++) {
            if (notPrime[i]) {
                continue;
            }

            for (int j = 2; i * j < notPrime.length; j++) {
                notPrime[i * j] = true;
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            if (!notPrime[number]) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
