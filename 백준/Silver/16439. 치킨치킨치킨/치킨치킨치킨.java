import java.util.Scanner;

public class Main {
    static int[][] prefer;
    static boolean[] visited;
    static int[] choice = new int[3];   //어느 치킨을 골랐는지
    static int answer = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        prefer = new int[n][m];
        visited = new boolean[m];

        for(int i = 0 ; i < n; i++)
            for(int j = 0; j < m; j++)
                prefer[i][j] = in.nextInt();

        for(int i = 0; i < m; i++) {
            dfs(0, i);
        }

        System.out.println(answer);
    }

    static void dfs(int depth, int node) {
        visited[node] = true;
        choice[depth] = node;

        //만족도 구하기
        if(depth == 2) {
            int total = 0;
            for(int i = 0; i < prefer.length; i++) {
                int satis = 0;
                for(int j = 0; j < choice.length; j++)
                    if(satis < prefer[i][choice[j]]) satis = prefer[i][choice[j]];
                total += satis;
            }

            answer = Math.max(answer, total);
            visited[node] = false;
            return;
        }

        for (int i = 0; i < prefer[0].length; i++)
            if (!visited[i]) dfs(depth + 1, i);

        visited[node] = false;
    }
}
