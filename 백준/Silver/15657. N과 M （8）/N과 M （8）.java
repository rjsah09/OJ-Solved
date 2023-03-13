import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static ArrayList<Integer> inputList = new ArrayList<>();
    static int[] outputList;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        outputList = new int[m];

        input = br.readLine();
        st = new StringTokenizer(input);
        while(st.hasMoreTokens())
            inputList.add(Integer.parseInt(st.nextToken()));
        Collections.sort(inputList);

        for(int i = 0; i < n; i++) {
            dfs(i, 0);
        }

        System.out.println(sb);
    }

    static void dfs(int node, int depth) {
        outputList[depth++] = inputList.get(node);

        if(depth == m) {
            for(int i = 0; i < m; i++)
                sb.append(outputList[i] + " ");
            sb.append("\n");
            return;
        }

        for(int i = node; i < n; i++)
            dfs(i, depth);
    }
}
