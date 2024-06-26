import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//09:50 ~ 10:00
//10:54 ~ 11:00

public class Main {

    static int N;  //세로 길이
    static int M;  //가로 길이
    static String[][] board;
    static boolean[][] visited;
    static int[] dx;
    static int[] dy;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new String[N][M];
        dx = new int[] {0, -1, 0, 1};
        dy = new int[] {-1, 0, 1, 0};
        max = 0;

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().split("");
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j].equals("L")) {
                    visited = new boolean[N][M];
                    visited[i][j] = true;
                    bfs(i, j);
                }
            }
        }

        System.out.println(max);
    }

    static void bfs(int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {row, col, 0});

        while (!q.isEmpty()) {
            int[] node = q.poll();
            max = Math.max(max, node[2]);

            for (int i = 0; i < 4; i++) {
                int nextRow = node[0] + dx[i];
                int nextCol = node[1] + dy[i];

                if (isIndexSafe(nextRow, nextCol) && board[nextRow][nextCol].equals("L") && !visited[nextRow][nextCol]) {
                    visited[nextRow][nextCol] = true;
                    q.add(new int[] {nextRow, nextCol, node[2] + 1});
                }
            }
        }

    }

    static boolean isIndexSafe(int row, int col) {
        return row >= 0 && col >= 0 && row < N && col < M;
    }
}
