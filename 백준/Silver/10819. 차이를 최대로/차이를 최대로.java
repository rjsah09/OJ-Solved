import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] numbers;
    static boolean[] visited;
    static int[] picked;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        visited = new boolean[N];
        picked = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        result = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            dfs(i, 0);
        }

        System.out.println(result);
    }

    static void dfs(int index, int depth) {
        visited[index] = true;
        picked[depth] = numbers[index];

        if (depth == N - 1) {
            result = Math.max(doOperation(), result);
            visited[index] = false;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                dfs(i, depth + 1);
            }
        }

        visited[index] = false;
    }

    static int doOperation() {
        int sum = 0;

        for (int i = 0; i < picked.length - 1; i++) {
            sum += Math.abs(picked[i] - picked[i + 1]);
        }

        return sum;
    }
}
