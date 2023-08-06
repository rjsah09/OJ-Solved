import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean prime[] = new boolean[N + 1];
        List<Integer> primeList = new ArrayList<>();
        prime[0] = prime[1] = true;
        for (int i = 2; i <= N; i++) {
            if (prime[i]) {
                continue;
            }

            if (i >= M && i <= N) {
                primeList.add(i);
            }

            for (int j = 2; i * j <= N; j++) {
                prime[i * j] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num: primeList) {
            sb.append(num + "\n");
        }

        System.out.println(sb);
    }
}
