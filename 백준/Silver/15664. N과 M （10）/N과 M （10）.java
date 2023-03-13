import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static boolean[] visited;
    static int[] inputList, outputList;
    static LinkedHashSet<String> ansList = new LinkedHashSet<>();
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st =  new StringTokenizer(input);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        inputList = new int[n];
        outputList = new int[m];
        visited = new boolean[n];

        input = br.readLine();
        st = new StringTokenizer(input);
        for(int i = 0; i < n; i++)
            inputList[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(inputList);

        for(int i = 0; i < n; i++)
            dfs(i, 0);

        Iterator<String> iter = ansList.iterator();
        sb = new StringBuilder();
        while(iter.hasNext())
            sb.append(iter.next() + "\n");

        System.out.println(sb);
    }

    static void dfs(int node, int depth) {
        visited[node] = true;
        outputList[depth++] = inputList[node];

        if(depth == m) {
            sb = new StringBuilder();
            for(int i = 0; i < m; i++) {
                sb.append(outputList[i] + " ");
            }
            ansList.add(sb.toString());
            visited[node] = false;
            return;
        }

        for(int i = node; i < n; i++) {
            if(!visited[i]) dfs(i, depth);
        }

        visited[node] = false;
    }
}