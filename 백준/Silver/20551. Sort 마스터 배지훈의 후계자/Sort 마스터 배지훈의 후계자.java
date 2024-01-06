import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(A);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(br.readLine());
            int start = 0;
            int end = N - 1;

            int resultIndex = -1;
            while (start <= end) {
                int midIndex = (start + end) / 2;
                int midValue = A[midIndex];

                if (midValue >= target) {
                    if (midValue == target) {
                        resultIndex = resultIndex == -1 ? midIndex : Math.min(midIndex, resultIndex);
                    }

                    end = midIndex - 1;
                } else {
                    start = midIndex + 1;
                }
            }

            sb.append(resultIndex + "\n");
        }

        System.out.println(sb);
    }
}
