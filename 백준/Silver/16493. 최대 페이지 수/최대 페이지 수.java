import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;   //남은 기간
    static int M;   //챕터의 수
    static int[][] board;
    static boolean[] visited;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[M][2];
        visited = new boolean[M];
        max = 0;
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            board[i][0] = Integer.parseInt(st.nextToken());
            board[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            int leftDays = N - board[i][0];
            if (leftDays >= 0) {
                visited[i] = true;
                dfs(i, board[i][1], leftDays);
                visited[i] = false;
            }
        }

        System.out.println(max);
    }

    static void dfs(int chapter, int readPages, int leftDays) {
        max = Math.max(readPages, max);

        for (int i = chapter; i < M; i++) {
            int newLeftDays = leftDays - board[i][0];
            if (!visited[i] && newLeftDays >= 0) {
                visited[i] = true;
                dfs(i, readPages + board[i][1], newLeftDays);
                visited[i] = false;
            }
        }
    }
}
