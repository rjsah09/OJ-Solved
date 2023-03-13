import java.util.Scanner;

public class Main {
    static int n;
    static int[][] ability;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        ability = new int[n][n];
        visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                ability[i][j] = in.nextInt();
            }
        }

        dfs(0);

        System.out.println(answer);
    }

    static void dfs(int node) {
        if(node == n) {
            int t1 = 0;
            int t2 = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i] && visited[j])
                        t1 += ability[i][j];
                    else if (!visited[i] && !visited[j])
                        t2 += ability[i][j];
                }
            }

            answer = Math.min(answer, Math.abs(t1 - t2));
            return;
        }

        visited[node] = true;   //1팀이라는 뜻
        dfs(node + 1);
        visited[node] = false;
        dfs(node + 1);
    }
}
