import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] spends = new int[N];

        int start = 0;
        int end = 0;
        for (int i = 0; i < N; i++) {
            spends[i] = Integer.parseInt(br.readLine());
            start = Math.max(start, spends[i]);
            end += spends[i];
        }

        int K = 0;
        while (start <= end) {
            int mid = (start + end ) / 2;

            int left = mid;
            int count = 1;
            for (int i = 0; i < spends.length; i++) {
                left -= spends[i];

                if (left < 0) {
                    left = mid - spends[i];
                    count++;
                }
            }

            if (count > M) {   //spend
                start = mid + 1;
            } else {
                K = mid;
                end = mid - 1;
            }
        }

        System.out.println(K);
    }

}
