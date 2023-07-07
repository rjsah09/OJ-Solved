import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        long answer = 0L;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] courseEnds = new long[N];
        long oneWayLength = 0;
        for (int i = 0; i < N; i++) {
            oneWayLength += Long.parseLong(st.nextToken());
            courseEnds[i] = oneWayLength;
        }

        long oneWayFinished = K / oneWayLength;
        long left = K % oneWayLength;
        //System.out.println("편도 횟수 = " + oneWayFinished);
        //System.out.println("남은 거리 = " + left);
        if (oneWayFinished % 2 == 0) {    //정방향
            for (int i = 0; i < courseEnds.length; i++) {
                //System.out.println("정방향 탐색");
                if (left < courseEnds[i]) {
                    answer = i + 1;
                    break;
                }
            }
        } else {    //역방향
            left = oneWayLength - left;
            //System.out.println("역방향 탐색, 거리 = " + left);
            for (int i = courseEnds.length - 1; i >= 0; i--) {
                //System.out.println("시작점 = " + courseEnds[i] + ", 거리 = " + left);
                if (left < courseEnds[i]) {
                    answer = i + 1;
                }
            }
        }

        System.out.println(answer);
    }
}
