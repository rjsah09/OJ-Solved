import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static boolean visited[];
    static int[] inputList, outputList;
    static HashSet<String> answerSet = new LinkedHashSet<>();
    static StringBuilder sb;
    static int[] prev;
    static int prevNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n];
        inputList = new int[n];
        outputList = new int[m];

        input = br.readLine();
        st = new StringTokenizer(input);
        for (int i = 0; i < n; i++)
                inputList[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(inputList);

        for(int i = 0; i < n; i++) {
            dfs(i, 0);
        }

        sb = new StringBuilder();
        Iterator<String> iter = answerSet.iterator();
        while(iter.hasNext()) {
            sb.append(iter.next());
            sb.append("\n");
        }

        System.out.println(sb);

    }

    static void dfs(int node, int depth) {
        visited[node] = true;
        outputList[depth++] = inputList[node];

        if(depth == m) {
            sb = new StringBuilder();
            for(int i = 0; i < m; i++)
                sb.append(outputList[i] + " ");
            answerSet.add(sb.toString());
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
