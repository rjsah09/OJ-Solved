import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //김밥의 개수
        int K = Integer.parseInt(st.nextToken());   //꼬다리의 길이
        int M = Integer.parseInt(st.nextToken());   //김밥조각의 최소 개수
        int[] lengths = new int[N];

        int end = 0;
        for (int i = 0; i < N; i++) {
            int length = Integer.parseInt(br.readLine());

            if (length >= 2 * K) {
                lengths[i] = length - 2 * K;
            } else if (length >= K) {
                lengths[i] = length - K;
            } else {
                lengths[i] = 0;
            }

            end = Math.max(end, lengths[i]);
        }

        int P = -1;
        int start = 1;
        while (start <= end) {
            int mid = (start + end) / 2;    //P의 길이

            int count = 0;
            for (int i = 0; i < lengths.length; i++) {
                count += lengths[i] / mid;
            }

            if (count >= M) {
                P = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(P);
    }
}