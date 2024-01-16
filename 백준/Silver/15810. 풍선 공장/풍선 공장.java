import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //스태프 인원 수
        int M = Integer.parseInt(st.nextToken());   //풍선의 개수
        int[] times = new int[N];

        long end = Long.MAX_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < times.length; i++) {
            times[i] = Integer.parseInt(st.nextToken());
            end = Math.min(end, times[i]);
        }

        long result = 0;
        long start = 1;
        end *= M;
        while (start <= end) {
            long mid = (start + end) / 2;   //모든 풍선 제작에 걸린 시간

            long count = 0;
            for (int i = 0; i < times.length; i++) {
                count += mid / times[i];
            }

            //System.out.println("mid = " + mid + ", count = " + count);

            if (count >= M) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(result);
    }
}