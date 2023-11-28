import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //나무의 개수
        int M = Integer.parseInt(st.nextToken());   //목재의 길이
        int[] heights = new int[N];
        int result = 0;

        st = new StringTokenizer(br.readLine());
        int end =  0;
        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
            end = Math.max(end, heights[i]);
        }

        int start = 0;
        while (start <= end) {
            int center = (start + end) / 2;
            long totalWoodLength = 0;

            for (int i = 0; i < heights.length; i++) {
                long woodLength = Math.max(heights[i] - center, 0);
                totalWoodLength += woodLength;
            }

            if (totalWoodLength >= M) {
                result = Math.max(result, center);
                start = center + 1;
            } else {
                end = center - 1;
            }
        }

        System.out.println(result);
    }
}