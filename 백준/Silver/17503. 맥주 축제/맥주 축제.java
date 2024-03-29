import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //축제 기간
        int M = Integer.parseInt(st.nextToken());   //선호도 합
        int K = Integer.parseInt(st.nextToken());   //맥주 종류
        int[][] beers = new int[K][2];

        long start = Long.MAX_VALUE;
        long end = 0;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            beers[i][0] = Integer.parseInt(st.nextToken()); //선호도
            beers[i][1] = Integer.parseInt(st.nextToken()); //도수 레벨
            start = Math.min(start, beers[i][1]);
            end = Math.max(end, beers[i][1]);
        }
        Arrays.sort(beers, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o2[0] - o1[0];
                }
            }
        });

        long result = -1;
        while (start <= end) {
            long mid = (start + end) / 2;   //최고 간 레벨

            /*PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            for (int i = 0; i < beers.length; i++) {
                if (beers[i][1] <= mid) {
                    pq.add(beers[i][0]);
                }
            }

            if (pq.size() < N) {
                start = mid + 1;
                continue;
            }

            long sum = 0;
            for (int i = 0; i < N; i++) {
                sum += pq.poll();
            }*/
            int count = 0;
            int sum = 0;
            for (int i = 0; i < beers.length; i++) {
                if (beers[i][1] <= mid && count < N) {
                    count++;
                    sum += beers[i][0];
                    if (count >= N) {
                        break;
                    }
                }
            }

            if (count < N) {
                start = mid + 1;
                continue;
            }

            if (sum >= M) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(result);
    }
}
