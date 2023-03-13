import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] inputList, outputList;
    static StringBuilder sb;
    static LinkedHashSet<String> answerSet = new LinkedHashSet<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        inputList = new int[n];
        outputList = new int[m];

        input = br.readLine();
        st = new StringTokenizer(input);
        for(int i =0; i < n; i++)
            inputList[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(inputList);

        for(int i = 0; i < n; i++)
            dfs(i, 0);

        Iterator<String> iter = answerSet.iterator();
        sb = new StringBuilder();
        while(iter.hasNext())
            sb.append(iter.next() + "\n");

        System.out.println(sb);
    }

    static void dfs(int node, int depth) {
        outputList[depth++] = inputList[node];

        if(depth == m) {
            sb = new StringBuilder();
            for(int i = 0; i < m; i++)
                sb.append(outputList[i] + " ");
            answerSet.add(sb.toString());
            return;
        }

        for(int i = 0; i < n; i++)
            dfs(i, depth);
    }
}
