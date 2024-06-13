import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;  //집합의 크기
    static Set<Integer> S;  //집합
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        S = new HashSet<>();
        min = Integer.MAX_VALUE;

        if (M > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                S.add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 1; i <= 2000; i++) {
            if (!S.contains(i)) {
                dfs(i, 1, i);
            }
        }

        System.out.println(min);
    }

    static void dfs(int index, int depth, int mul) {
        if (depth == 3) {
            int result = Math.abs(N - mul);
            min = Math.min(min, result);
            return;
        }

        if (mul >= N && Math.abs(N - mul) > min) {
            return;
        }

        for (int i = 1; i <= 100; i++) {
            if (!S.contains(i)) {

                dfs (i, depth + 1, mul * i);
            }
        }
    }
}
