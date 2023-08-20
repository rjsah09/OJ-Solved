import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] board;

    static int[] dx;
    static int[] dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        dx = new int[] {0, -1, 0, 1};
        dy = new int[] {-1, 0, 1, 0};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            board = new int[N][M];

            int cabbageCount = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cabbageCount; j++) {
                st = new StringTokenizer(br.readLine());
                int posI = Integer.parseInt(st.nextToken());
                int posJ = Integer.parseInt(st.nextToken());

                board[posI][posJ] = 1;
            }

            int wormCount = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (board[j][k] == 1) {
                        bfs(j, k);
                        wormCount++;
                    }
                }
            }
            sb.append(wormCount).append("\n");
        }

        System.out.println(sb);
    }

    static void bfs(int posI, int posJ) {
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[] {posI, posJ});
        board[posI][posJ] = 0;

        while (!q.isEmpty()) {
            Integer[] pos = q.poll();

            for (int i = 0; i < 4; i++) {
                if (isAreaSafe(pos[0] + dx[i], pos[1] + dy[i]) && board[pos[0] + dx[i]][pos[1] + dy[i]] == 1) {
                    q.add(new Integer[] {pos[0] + dx[i], pos[1] + dy[i]});
                    board[pos[0] + dx[i]][pos[1] + dy[i]] = 0;
                }
            }

        }
    }

    static boolean isAreaSafe(int posI, int posJ) {
        if (posI < 0 || posI >= board.length || posJ < 0 || posJ >= board[0].length) {
            return false;
        }

        return true;
    }
}