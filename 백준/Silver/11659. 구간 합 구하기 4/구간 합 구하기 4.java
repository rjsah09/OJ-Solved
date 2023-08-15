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

        long[] prefixSums = new long[N];
        st = new StringTokenizer(br.readLine());
        prefixSums[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            prefixSums[i] = prefixSums[i - 1] + Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 2;
            int end = Integer.parseInt(st.nextToken()) - 1;

            if (start == -1) {
                sb.append(prefixSums[end]).append("\n");
                continue;
            }
            sb.append(prefixSums[end] - prefixSums[start]).append("\n");
        }

        System.out.println(sb);
    }

}
