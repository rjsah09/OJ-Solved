import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long answer = 0L;
        int N = Integer.parseInt(br.readLine());
        int[] budgets = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            budgets[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(budgets);

        long M = Integer.parseInt(br.readLine());

        long start = 0L;
        long end = M;
        while (start <= end) {
            long center = (start + end) / 2L;

            long totalBudget = 0L;
            for (int i = 0; i < N; i++) {
                if (center >= budgets[i]) {
                    totalBudget += budgets[i];
                } else {
                    totalBudget += center;
                }
            }

            if (totalBudget > M) {
                end = center - 1L;
            } else {
                answer = Math.max(answer, center);
                start = center + 1L;
            }
        }

        if (answer > budgets[N - 1]) {
            System.out.println(budgets[N - 1]);
        } else {
            System.out.println(answer);
        }
    }
}
