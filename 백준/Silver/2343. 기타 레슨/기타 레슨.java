import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //강의의 수
        int M = Integer.parseInt(st.nextToken());   //블루레이 수
        int[] lectures = new int[N];

        st = new StringTokenizer(br.readLine());
        int start = 0;
        int end = 0;
        for (int i = 0; i < N; i++) {
            lectures[i] = Integer.parseInt(st.nextToken());
            start = Math.max(start, lectures[i]);
            end += lectures[i];
        }

        int result = 0;
        while (start <= end) {
            int mid = (start + end) / 2;    //최대 영상 길이

            int count = 0;
            int length = 0;
            for (int i = 0; i < N; i++) {
                if (length + lectures[i] > mid) {
                    count++;
                    length = lectures[i];
                } else {
                    length += lectures[i];
                }
            }

            if (length > 0) {
                count++;
            }

            //System.out.println("mid = " + mid + ", count = " + count);

            if (count <= M) {
                result = mid;
                end = mid - 1;
            } else{
                start = mid + 1;
            }
        }

        System.out.println(result);
    }
}
