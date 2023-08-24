import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[] visitedTime;
    static int second;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   //수빈의 위치
        K = Integer.parseInt(st.nextToken());   //동생의 위치
        visitedTime = new int[Math.max(N, K) * 2];

        second = -1;
        if (Math.abs(N - K) == 1) {
            second = 1;
        } else if (Math.abs(N - K) == 0) {
            second = 0;
        } else {
            bfs(N);
        }

        System.out.println(second);
    }

    static void bfs(int position) {
        Queue<Integer> q = new LinkedList<>();
        q.add(position);
        visitedTime[position] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == K) {
                second = visitedTime[now];
                return;
            }

            //탐색 조건 = -1, +1, * 2
            if (now + 1 < visitedTime.length && visitedTime[now + 1] == 0) {
                visitedTime[now + 1] = visitedTime[now] + 1;
                q.add(now + 1);
            }

            if (now - 1 >= 0 && visitedTime[now - 1] == 0) {
                visitedTime[now - 1] = visitedTime[now] + 1;
                q.add(now - 1);
            }

            if (now * 2 < visitedTime.length && visitedTime[now * 2] == 0) {
                visitedTime[now * 2] = visitedTime[now] + 1;
                q.add(now * 2);
            }
        }
    }
}