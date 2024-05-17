import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1분
//25분
//4분
//26분
//11분
//6:40 ~
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());   //늘려야 하는 최소 고객 수
        int N = Integer.parseInt(st.nextToken());   //도시의 개수
        int[] costs = new int[N];
        int[] increases = new int[N];
        int max = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            costs[i] = Integer.parseInt(st.nextToken());
            increases[i] = Integer.parseInt(st.nextToken());
            max = Math.max(increases[i], max);
        }

        int[] dp = new int[C + max];  //고객을 N명 유치했을 떄의 최소값

        for (int i = 0; i < costs.length; i++) {
            dp[increases[i]] = dp[increases[i]] == 0 ? costs[i] : Math.min(dp[increases[i]], costs[i]);    //increases[i]명을 만드는 경우 cos
//            dp[increases[i]] = costs[i];
        }

        for (int i = 1; i < dp.length; i++) {  //총 i명을 유치한 경우
            for (int j = 0; j < costs.length; j++) {   //마지막에 j번째 도시를 선택해 유치한 경우
                int increase = increases[j];    //j번째 도시를 선택했을 때의 인원 증가량
                int cost = costs[j];            //j번째 도시를 선택했을 때의 비용

                if (i - increase <= 0 || dp[i - increase] == 0) {    //이전 값이 0인 경우 나올 수 없는 경우이므로 continue
                    continue;
                }

                dp[i] = dp[i] == 0 ? dp[i - increase] + cost : Math.min(dp[i - increase] + cost, dp[i]);
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = C; i < dp.length; i++) {
            if (dp[i] != 0) {
                result = Math.min(result, dp[i]);
            }
        }

        System.out.println(result);
    }
}