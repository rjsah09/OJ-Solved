import java.util.Scanner;

public class Main {
    static int n;
    static int[][] land;
    static boolean[][] visited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        land = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                land[i][j] = in.nextInt();
        }

        for(int i = 1; i < n - 1; i++) {
            for(int j = 1; j < n - 1; j++) {
                dfs(i, j, 0);
            }
        }

        System.out.println(answer);
    }

    static void dfs(int nodeI, int nodeJ, int depth) {
        mark(nodeI, nodeJ);

        if(depth == 2) {
            int res = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(visited[i][j]) res += land[i][j];
                }
            }
            answer = Math.min(answer, res);
            blank(nodeI, nodeJ);
            return;
        }

        for(int i = 1; i < n - 1; i++) {
            for(int j = 1; j < n - 1; j++) {
                if(canPlant(i, j))
                    dfs(i, j , depth  +1);
            }
        }


        blank(nodeI, nodeJ);
    }

    static void mark(int nodeI, int nodeJ) {
        visited[nodeI][nodeJ] = true;
        visited[nodeI + 1][nodeJ] = true;
        visited[nodeI - 1][nodeJ] = true;
        visited[nodeI][nodeJ + 1] = true;
        visited[nodeI][nodeJ - 1] = true;
    }

    static void blank(int nodeI, int nodeJ) {
        visited[nodeI][nodeJ] = false;
        visited[nodeI + 1][nodeJ] = false;
        visited[nodeI - 1][nodeJ] = false;
        visited[nodeI][nodeJ + 1] = false;
        visited[nodeI][nodeJ - 1] = false;
    }

    static boolean canPlant(int nodeI, int nodeJ) {
        if(visited[nodeI][nodeJ] || visited[nodeI + 1][nodeJ] || visited[nodeI - 1][nodeJ] || visited[nodeI][nodeJ + 1] || visited[nodeI][nodeJ - 1])
            return false;
        return true;
    }

}