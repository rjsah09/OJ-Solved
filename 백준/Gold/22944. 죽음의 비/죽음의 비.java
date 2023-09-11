import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, H, D;
    static String[][] board;
    static int[] dx;
    static int[] dy;
    static int result;

    static int[][] visited;
    static int[] start;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   //맵의 변 길이
        H = Integer.parseInt(st.nextToken());   //현재 체력
        D = Integer.parseInt(st.nextToken());   //우산의 내구도
        dx = new int[] {-1, 1, 0, 0};   //row
        dy = new int[] {0, 0, -1, 1};   //col
        board = new String[N][N];
        visited = new int[N][N];
        result = -1;

        start = new int[] {0, 0};
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                String area = line.substring(j, j + 1);
                board[i][j] = area;
                if (area.equals("S")) {
                    start = new int[]{i, j};
                }
            }
        }

        bfs(start[0], start[1]);

        System.out.println(result);
    }

    static void bfs(int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col, 0, H, 0});   //행, 열, 우산의 체력, 현재 체력, 거리
        visited[row][col] = H;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            String nowArea = board[now[0]][now[1]];

            if (nowArea.equals(".")) {
                if (now[2] > 0) {
                    now[2]--;
                } else {
                    now[3]--;
                }

                if (now[3] <= 0) {    //체력이 0이라면 continue;
                    continue;
                }
            } else if (nowArea.equals("E")) {
                result = result == -1 ? now[4] : Math.min(result, now[4]);
            } else if (nowArea.equals("U")) {
                now[2] = D - 1;
            }

            for (int i = 0; i < 4; i++) {
                int nextRow = now[0] + dx[i];
                int nextCol = now[1] + dy[i];
                if (isIndexSafe(nextRow, nextCol) && visited[nextRow][nextCol] < now[2] + now[3]) {
                    visited[nextRow][nextCol] = now[2] + now[3];
                    q.add(new int[] {nextRow, nextCol, now[2], now[3], now[4] + 1});
                }
            }

        }
    }

    static boolean isIndexSafe(int row, int col) {
        if (row < 0 || row >= N || col < 0 || col >= N) {
            return false;
        }


        return true;
    }
}
