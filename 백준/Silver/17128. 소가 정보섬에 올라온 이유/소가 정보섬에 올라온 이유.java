import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //소의 수
        int Q = Integer.parseInt(st.nextToken());   //장난의 횟수

        int[] grades = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            grades[i] = Integer.parseInt(st.nextToken());
        }

        int[] sums = new int[N];
        for (int i = 0; i < N; i++) {
            sums[i] = grades[i % N] * grades[(i + 1) % N] * grades[(i + 2) % N] * grades[(i + 3) % N];
        }

        int total = 0;
        for (int j = 0; j < sums.length; j++) {
            total += sums[j];
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            int joke = Integer.parseInt(st.nextToken()) - 1;
            for (int j = 0; j < 4; j++) {
                sums[(N - j + joke) % N] *= -1;
                total += 2 * sums[(N - j + joke) % N];
            }
            System.out.println(total);
        }
    }
}