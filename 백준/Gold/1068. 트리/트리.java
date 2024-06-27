import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//09:50 ~ 10:02
//10:42 ~ 10:49

public class Main {

    static int N;
    static ArrayList<Integer>[] adj;
    static int root;
    static int deleted;
    static int leafCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());

            if (parent == -1) {
                root = i;
            } else {
                adj[parent].add(i);
            }
        }

        deleted = Integer.parseInt(br.readLine());
        leafCount = 0;
        if (root != deleted) {
            dfs(root);
        }

        System.out.println(leafCount);
    }

    static void dfs(int node) {
        int childCount = adj[node].size();
        if (adj[node].contains(deleted)) {
            childCount--;
        }

        if (childCount == 0) {
            leafCount++;
            return;
        }

        for (int i = 0; i < adj[node].size(); i++) {
            int nextNode = adj[node].get(i);

            if (nextNode != deleted) {
                dfs(nextNode);
            }
        }
    }
}
