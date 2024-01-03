import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] x = new int[M];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            x[i] = Integer.parseInt(st.nextToken());
        }

        int start  = 1;
        int end = N;
        while (start <= end) {
            int mid = (start + end) / 2;

            int lastLighted = 0;
            boolean allLighted = true;
            for (int i = 0; i < x.length; i++) {
                int point = x[i];
                if (point - mid <= lastLighted) {
                    lastLighted = point + mid;
                } else {
                    allLighted = false;
                    break;
                }
            }

            if (allLighted && lastLighted >= N) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(start);
    }
}