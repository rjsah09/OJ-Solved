import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] inputList;
    static int[] outputList;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        outputList = new int[m];

        input = br.readLine();
        String[] strList = input.split(" ");
        inputList = new int[strList.length];
        for(int i = 0; i < n; i++)
            inputList[i] = Integer.parseInt(strList[i]);
        Arrays.sort(inputList);

        visited = new boolean[inputList.length];
        for(int i = 0; i < n; i++) {
            dfs(i, 0);
        }

        System.out.println(sb);
    }

    static void dfs(int node, int depth) {
        visited[node] = true;
        outputList[depth++] = inputList[node];

        if(depth == m) {
            for(int i = 0; i < m; i++)
                sb.append(outputList[i] + " ");
            sb.append("\n");
            visited[node] = false;
            return;
        }

        for(int i = 0; i < n; i++) {
            if(!visited[i])
                dfs(i, depth);
        }

        visited[node] = false;
    }
}