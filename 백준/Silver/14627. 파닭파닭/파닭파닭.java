import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());   //파의 개수
        int C = Integer.parseInt(st.nextToken());   //주문 수
        int[] onions = new int[S];

        long totalLength = 0L;
        long end = 0;
        for (int i = 0; i < onions.length; i++) {
            onions[i] = Integer.parseInt(br.readLine());
            end = Math.max(end, onions[i]);
            totalLength += onions[i];
        }

        long result = 0;
        long start = 1;
        while (start <= end) {
            long mid = (start + end) / 2;

            int count = 0;
            for (int i = 0; i < onions.length; i++) {
                count += onions[i] / mid;
            }

            //System.out.println("mid = " + mid + ", count = " + count);

            if (count >= C) {
                result = totalLength - C * mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(result);
    }
}
