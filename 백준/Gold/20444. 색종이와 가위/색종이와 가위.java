import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());   //가위질 횟수
        long K = Long.parseLong(st.nextToken());   //종이 조각 개수

        long start = 0L;
        long end = N / 2;
        while (start <= end) {
            long mid = (start + end) / 2;    //가로 가위질 개수
            //System.out.println("가로 = " + mid + ", 세로 = " + (N - mid) + ", 결과 =" + (mid * (N - mid)));

            long pieces = (mid + 1) * (N - mid + 1);
            if (pieces > K) {
                end = mid - 1;
            } else if (pieces < K) {
                start = mid + 1;
            } else {
                System.out.println("YES");
                return;
            }
        }

        System.out.println("NO");
    }
}
