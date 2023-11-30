import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long[] lengths = new long[K];
        long start = 1;
        long end = 0;
        long result = 0;

        for (int i = 0; i < K; i++) {
            lengths[i] = Long.parseLong(br.readLine());
            end = Math.max(lengths[i], end);
        }

        while (start <= end) {
            long center = (start + end) / 2; //잘라낸 랜선의 길이

            long totalCut = 0;   //자른 랜선의 총 개수
            for (int i = 0; i < lengths.length; i++) {
                totalCut += lengths[i] / center;
            }

            if (totalCut >= N) {
                result = Math.max(center, result);
                start = center + 1;
            } else {
                end = center - 1;
            }
        }

        System.out.println(result);
    }
}
