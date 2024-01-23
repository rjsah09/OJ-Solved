import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //아이들의 수
        int M = Integer.parseInt(st.nextToken());   //색상의 수
        int[] jealous = new int[M];

        int end = 0;
        for (int i = 0; i < M; i++) {
            jealous[i] = Integer.parseInt(br.readLine());
            end = Math.max(end, jealous[i]);
        }

        int result = Integer.MAX_VALUE;
        int start = 1;
        while (start <= end) {
            int mid = (start + end) / 2;    //1인당 보석의 최대 개수

            int count = 0;
            int max = 0;
            for (int i = 0; i < M; i++) {
                if (jealous[i] <= mid) {
                    count++;
                    max = Math.max(max, jealous[i]);
                } else {
                    count += jealous[i] / mid;
                    if (jealous[i] % mid > 0) {
                        count++;
                    }
                    max = Math.max(max, mid);
                }
            }

            if (count <= N) {
                result = Math.min(result, max);
                end = mid -1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(result);
    }
}
