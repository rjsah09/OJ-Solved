import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static int N;
    static int[] numbers;
    static Set<Integer> madeNumbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[]{1, 5, 10, 50};
        madeNumbers = new HashSet<>();

        for (int i = 0; i <= N; i++) {
            dfs(0, i, numbers[0] * i);
        }

        System.out.println(madeNumbers.size());
    }

    static void dfs(int depth, int used, int sum) {
        if (depth == 3) {
            if (used == N) {
                madeNumbers.add(sum);
            }
            return;
        }

        int left = N - used;
        for (int i = 0; i <= left; i++) {
            dfs(depth + 1, used + i, sum + numbers[depth + 1] * i);
        }
    }
}