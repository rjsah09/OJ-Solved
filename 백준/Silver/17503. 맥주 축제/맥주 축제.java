import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //축제 기간
        int M = Integer.parseInt(st.nextToken());   //선호도 합
        int K = Integer.parseInt(st.nextToken());   //맥주 종류
        int[][] beers = new int[K][2];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            beers[i][0] = Integer.parseInt(st.nextToken()); //선호도
            beers[i][1] = Integer.parseInt(st.nextToken()); //도수 레벨
        }
        Arrays.sort(beers, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o1[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });

        long result = -1;
        long start = 0;
        long end = beers.length - 1;
        while (start <= end) {
            long mid = (start + end) / 2;   //최고 간 레벨

            if (N - 1 > mid) {
                start =  mid + 1;
                continue;
            }

            PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });

            for (int i = 0; i <= mid; i++) {
                pq.add(beers[i][0]);
            }

            long sum = 0;
            for (int i = 0; i < N; i++) {
                sum += pq.poll();
            }

            //System.out.println("mid = " + mid + ", sum = " + sum + ", midValue = " + beers[(int)mid][1]);

            if (sum >= M) {
                result = beers[(int)mid][1];
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(result);
    }
}