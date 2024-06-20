import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[][] board;
    static int[] dx;
    static int[] dy;
    static String result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        dx = new int[] {0, -1, 0, 1};
        dy = new int[] {-1, 0, 1, 0};
        result = "NO";

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }

        for (int i = 0; i < M; i++) {
            if (board[0][i] == 0 && result.equals("NO")) {
                board[0][i] = 1;
                bfs(0, i);
            }
        }

        System.out.println(result);
    }

    static void bfs(int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        int[] startNode = new int[] {row, col};
        q.add(startNode);

        while (!q.isEmpty()) {
            int[] node = q.poll();

            if (node[0] == N - 1) {
                result = "YES";
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextRow = node[0] + dx[i];
                int nextCol = node[1] + dy[i];

                if (isIndexSafe(nextRow, nextCol) && board[nextRow][nextCol] == 0) {
                    board[nextRow][nextCol] = 1;
                    q.add(new int[] {nextRow, nextCol});
                }
            }
        }
    }

    static boolean isIndexSafe(int row, int col) {
        return row >= 0 && col >= 0 && row < N && col < M;
    }
}