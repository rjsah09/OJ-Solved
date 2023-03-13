import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int nodes;
    static int[][] adj;
    static int traveled = 0;
    static boolean isRight = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        nodes = Integer.parseInt(input);
        adj = new int[nodes][2];

        for(int i = 0; i < nodes; i++) {
            input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);

            int parent = Integer.parseInt(st.nextToken()) - 1;
            for(int j = 0; j < 2; j++)
                adj[parent][j] = Integer.parseInt(st.nextToken()) - 1;
        }

        dfsInorder(0);
        System.out.println(traveled);
    }

    static void dfsInorder(int node) {
        int left = adj[node][0];
        int right = adj[node][1];

        if(left >= 0) {
            dfsInorder(left);
            traveled++;
        } else if(left < 0 && right < 0) {
            if(node != 0)traveled++;
            return;
        }

        if(right >= 0) {
            if(node == 0) isRight = true;
            dfsInorder(right);
            if(!isRight) traveled++;
        }

        if(node != 0) traveled++;
    }
}