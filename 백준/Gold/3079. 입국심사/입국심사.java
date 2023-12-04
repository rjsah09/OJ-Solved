import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //입국 심사대 개수
        int M = Integer.parseInt(st.nextToken());   //여행 인원수
        long[] screeningTimes = new long[N];

        long start = Long.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            screeningTimes[i] = Long.parseLong(br.readLine());
            start = Math.min(start, screeningTimes[i]);
        }

        /*System.out.println("총 " + M + "명");

        System.out.println("걸리는 시간");
        for (int i = 0; i < N; i++) {
            System.out.print(screeningTimes[i] + " ");
        }
        System.out.println();*/

        long end = start * M;
        long result = end;
        while (start <= end) {
            long center = (start + end) / 2;    //심사대 당 걸리는 시간
//            System.out.println(center + "초 인 경우--------------------");

            long screened = 0;
            for (int i = 0; i < N; i++) {
                screened += center / screeningTimes[i];
                /*System.out.println(screeningTimes[i] + "초 걸리는 심사대에서" + (center / screeningTimes[i]) + "명 심사 가능");*/
            }

            if (screened >= M) {    //모든 인원 center 초 안에 심사 가능 -> center 값을 줄여야 함
                end = center - 1;
                result = Math.min(result, center);
            } else {    //모든 인원 center 초 안에 심사 불가 -> center 값을 늘려야 함
                start = center  + 1;
            }
        }

        System.out.println(result);
    }
}