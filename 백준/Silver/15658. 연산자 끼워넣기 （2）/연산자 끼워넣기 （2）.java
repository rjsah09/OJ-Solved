import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] numbers;
    static int[] leftOperatorCount;
    static int max, min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        leftOperatorCount = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            leftOperatorCount[i] = Integer.parseInt(st.nextToken());
        }

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            if (leftOperatorCount[i] > 0) {
                leftOperatorCount[i]--;
                dfs(numbers[0], 1, i);
                leftOperatorCount[i]++;
            }
        }

        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int prev, int node, int operator) {
        if (leftOperatorCount[operator] < 0) {
            return;
        }

        int operationResult = doOperation(prev, node, operator);

        if (node == N - 1) {
            max = Math.max(max, operationResult);
            min = Math.min(min, operationResult);
        } else {
            for (int i = 0; i < 4; i++) {
                if (leftOperatorCount[i] > 0) {
                    leftOperatorCount[i]--;
                    dfs(operationResult, node + 1, i);
                    leftOperatorCount[i]++;
                }
            }
        }
    }

    static int doOperation(int prev, int node, int operator) {
        switch (operator) {
            case 0:
                return prev + numbers[node];
            case 1:
                return prev -numbers[node];
            case 2:
                return prev * numbers[node];
            case 3:
                return prev / numbers[node];
        }

        return 0;
    }
}
