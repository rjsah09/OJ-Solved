import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int N, M, K, X; //노드 N, 엣지 M, 거리정보 K, 시작노드 X
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken()) - 1;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] depth = new int[N];   //각 노드별 최소 깊이(거리)

        for(int i = 0; i < N; i++) {
            adj.add(new ArrayList<Integer>());
            depth[i] = -1;  //각 노드별 깊이를 -1로 초기화(0으로 초기화시 시작노드의 문제가 발생 가능)
        }

        for(int i = 0; i < M; i++) {
            input = br.readLine();
            st = new StringTokenizer(input);
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            adj.get(start).add(end);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(X);
        depth[X] = 0;
        while(!q.isEmpty()) {
            int node = q.poll();
            if(depth[node] > K)
                break;

            for(int i = 0; i < adj.get(node).size(); i++) {
                int next = adj.get(node).get(i);

                if(depth[next] == -1) {
                    q.add(next);
                    depth[next] = depth[node] + 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            if(depth[i] == K)
                sb.append((i + 1) + "\n");
        }

        if(sb.toString().equals("")) {
            System.out.println(-1);
            return;
        }

        System.out.println(sb);
    }
}