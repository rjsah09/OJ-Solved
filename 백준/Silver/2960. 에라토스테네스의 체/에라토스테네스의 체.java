import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] prime = new boolean[N + 1];
        prime[0] = prime[1] = true;
        int deleted = 0;
        for (int i = 0; i < prime.length; i++) {
            if (prime[i]) {
                continue;
            }

            for (int j = 1; i * j < prime.length; j++) {
                if (!prime[i * j]) {
                    prime[i * j] = true;
                    deleted++;
                }

                if (deleted == K) {
                    System.out.println(i * j);
                    return;
                }
            }
        }
    }
}