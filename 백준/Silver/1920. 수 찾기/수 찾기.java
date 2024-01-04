import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            int contain = 0;
            if (contains(target)) {
                contain = 1;
            }

            sb.append(contain + "\n");
        }

        System.out.println(sb);
    }

    static boolean contains(int target) {
        int start = 0;
        int end = N - 1;

        while (start <= end) {
            int midIndex = (start + end) / 2;
            int midValue = A[midIndex];

            if (midValue > target) {
                end = midIndex - 1;
            } else if (midValue < target) {
                start = midIndex + 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
