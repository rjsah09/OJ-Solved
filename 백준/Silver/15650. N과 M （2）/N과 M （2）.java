import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] list;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new int[m];
        dfs(0, 0, true);
        dfs(0, 0, false);

        System.out.println(sb);
    }

    static void dfs(int node, int count, boolean checked) {
        if(checked) {
            list[count] = node + 1;
            count++;
        }

        if(count == m) {
            for(int i = 0; i < m; i++)
                sb.append(list[i] + " ");
            sb.append("\n");
            return;
        }

        if(node < n - 1) {
            dfs(node + 1, count, true);
            dfs(node + 1, count, false);
        }

    }
}