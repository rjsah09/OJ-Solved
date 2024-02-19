import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //캐릭터 개수
        int K = Integer.parseInt(st.nextToken());   //레벨 총합
        int[] levels = new int[N];

        long start = Long.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            levels[i] = Integer.parseInt(br.readLine());
            start = Math.min(start, levels[i]);
        }

        long T = 0;
        long end = start + K;
        while (start <= end) {
            long mid =  (start + end) / 2;  //T

            long levelAddition = 0;
            for (int i = 0; i < levels.length; i++) {
                levelAddition += mid > levels[i] ? mid - levels[i] : 0;
            }

            if (levelAddition > K) {
                end = mid - 1;
            } else {
                T = mid;
                start = mid + 1;
            }
        }

        System.out.println(T);
    }
}