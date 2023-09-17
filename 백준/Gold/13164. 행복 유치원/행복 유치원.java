import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[] heights;
    static Integer[] heightsDiff;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        heights = new int[N];
        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        heightsDiff = new Integer[N  - 1];
        for (int i = 0; i < heightsDiff.length; i++) {
            heightsDiff[i] = heights[i + 1] - heights[i];
        }

        Arrays.sort(heightsDiff, Collections.reverseOrder());
        int sum = 0;
        for (int i = K - 1; i < heightsDiff.length; i++) {
            sum += heightsDiff[i];
        }

        System.out.println(sum);
    }

}