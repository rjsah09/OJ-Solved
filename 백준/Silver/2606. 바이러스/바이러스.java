import java.util.Scanner;

public class Main {
    static boolean[][] adjMatrix;
    static boolean[] visited;
    static int nodes;
    static int edges;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        nodes = in.nextInt();
        edges = in.nextInt();
        adjMatrix = new boolean[nodes][nodes];
        visited = new boolean[nodes];

        for(int i = 0; i < edges; i++) {
            int n1 = in.nextInt() - 1;
            int n2 = in.nextInt() - 1;
            adjMatrix[n1][n2] = true;
            adjMatrix[n2][n1] = true;
        }

        dfs(0);
        System.out.println(answer);
    }

    static void dfs(int node) {
        visited[node] = true;

        if(node > 0)
            answer++;

        for(int i = 0; i < nodes; i++) {
            if(adjMatrix[node][i] && !visited[i])
                dfs(i);
        }
    }
}