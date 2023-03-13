import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] inputArr;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        inputArr = new int[n];

        input = br.readLine();
        st = new StringTokenizer(input);
        for (int i = 0; i < n; i++)
            inputArr[i] = Integer.parseInt(st.nextToken());

        dfs(0, 0);
        dfs(0, inputArr[0]);

        if(m == 0) answer--;
        System.out.println(answer);
    }

    static void dfs(int depth, int sum) {
        if(depth == n - 1) {
            if(sum == m) answer++;
            return;
        }

        dfs(depth + 1, sum);
        dfs(depth + 1, sum + inputArr[depth + 1]);
    }
}