import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;   //돌의 개수
    static int K;   //최대 낼 수 있는 힘
    static int[] powers;    //N번째 돌에서 요구하는 힘(Ai)
    static boolean[] dp;    //N번째 돌을 건너갈 수 있는지 저장하기 위한 배열

    public static void main(String[] args) throws IOException {
        //값 초기화 시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        powers = new int[N];
        dp = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            powers[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = true;
        //값 초기화 끝

        /*//dp 계산 시작
        for (int i = 1; i < N; i++) {   //도착점
            for (int j = 0; j < i; j++) {   //시작점
                if (!dp[j]) {   //시작점이 도착 불가능한 지역이라면 계산할 필요가 없으므로 continue
                    continue;
                }

                int required = getRequiredPower(j, i);  //j에서 i로 가는 비용을 계산하고 required 변수에 저장한다

                if (required <= K) {    //비용이 K보다 작은 경우 건널 수 있다는 뜻이므로 dp[i]를 true로 갱신한다
                    dp[i] = true;
                }
            }
        }
        //dp 계산 끝*/

        //2안
        for (int i = 0; i < N; i++) {  //시작점
            if (!dp[i]) {
                continue;
            }

            for (int j = i + 1; j < N; j++) {   //끝점
                int required = getRequiredPower(i, j);  //j에서 i로 가는 비용을 계산하고 required 변수에 저장한다

                if (required <= K) {    //비용이 K보다 작은 경우 건널 수 있다는 뜻이므로 dp[i]를 true로 갱신한다
                    dp[j] = true;
                }
            }
        }

        //dp[N -1]의 값에 따라 출력할 문구를 선택한다
        String result = dp[N - 1] ? "YES" : "NO";
        System.out.println(result);
    }

    //start에서 end로 가는 비용을 반환하는 메서드
    static int getRequiredPower(int start, int end) {
        return (end - start) * (1 + Math.abs(powers[start] - powers[end]));
    }
}
