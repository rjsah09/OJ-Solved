import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int k;
    static int[] s;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        sb = new StringBuilder();
        while (!line.equals("0")) {
            StringTokenizer st = new StringTokenizer(line);
            k = Integer.parseInt(st.nextToken());
            s = new int[k];
            visited = new boolean[k];

            for (int i = 0; i < k; i++) {
                s[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < k; i++) {
                dfs(i, 1);
            }

            line = br.readLine();
            if (!line.equals("0")) {
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    static void dfs(int index, int depth) {
        visited[index] = true;

        if (depth == 6) {
            sb.append(getPickedNumbers() + "\n");
            visited[index] = false;
            return;
        }

        for (int i = index; i < s.length; i++) {
            if (!visited[i]) {
                dfs(i, depth + 1);
            }
        }

        visited[index] = false;
    }

    static String getPickedNumbers() {
        String numbers = "";

        for (int i = 0; i < s.length; i++) {
            if (visited[i]) {
                numbers += s[i] + " ";
            }
        }

        return numbers;
    }
}
