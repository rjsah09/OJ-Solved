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
        st = new StringTokenizer(input);
        while(st.hasMoreTokens())
            inputList.add(Integer.parseInt(st.nextToken()));
        Collections.sort(inputList);

        dfs(0, 0, true);
        dfs(0, 0, false);

        System.out.println(sb);
    }

    static void dfs(int node, int count, boolean checked) {
        if(checked) {
            outputList[count] = inputList.get(node);
            count++;
        }

        if(count == m) {
            for(int i = 0; i < m; i++)
                sb.append(outputList[i] + " ");
            sb.append("\n");
            return;
        }

        if(node < n - 1) {
            dfs(node + 1, count, true);
            dfs(node + 1, count, false);
        }

    }
}
