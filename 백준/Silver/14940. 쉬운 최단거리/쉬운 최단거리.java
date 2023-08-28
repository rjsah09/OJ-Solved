import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] board;
    static int[][] distanceBoard;

    static int[] dx, dy;
    static int[] start;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        distanceBoard = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(distanceBoard[i], -1);
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 2) {
                    start = new int[]{i, j};
                } else if (board[i][j] == 0) {
                    distanceBoard[i][j] = 0;
                }
            }
        }

        dx = new int[] {0, -1, 0, 1};
        dy = new int[]{-1, 0, 1, 0};
        bfs(start);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < distanceBoard.length; i++) {
            for (int j = 0; j < distanceBoard[0].length; j++) {
                sb.append(distanceBoard[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void bfs(int[] start) {
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        distanceBoard[start[0]][start[1]] = 0;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int[] next = {now[0] + dx[i], now[1] + dy[i]};

                if (isIndexSafe(next) && distanceBoard[next[0]][next[1]] == -1 && board[next[0]][next[1]] == 1) {
                    distanceBoard[next[0]][next[1]] = distanceBoard[now[0]][now[1]] + 1;
                    q.add(next);
                }
            }
        }
    }

    static boolean isIndexSafe(int[] position) {
        if (position[0] < 0 || position[0] >= N || position[1] < 0 || position[1] >= M) {
            return false;
        }

        return true;
    }
}