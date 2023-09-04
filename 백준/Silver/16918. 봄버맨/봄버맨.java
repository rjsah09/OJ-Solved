import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int R, C, N;
    static int[][] board;
    static int[] dx, dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        board = new int[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();

            for (int j = 0; j < C; j++) {
                String tile = line.substring(j, j + 1);
                if (tile.equals(".")) {
                    board[i][j] = -1;
                } else {
                    board[i][j] = 3;
                }
            }
        }

        dx = new int[] {0, -1, 0, 1};
        dy = new int[] {-1, 0, 1, 0};

        //i는 현재 진행된 시간
        for (int i = 1; i <= N; i++) {
            if (i % 2 == 0) {
                plant(i);
            }

            explodeAll(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == -1) {
                    sb.append(".");
                } else {
                    sb.append("O");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static boolean isIndexSafe(int row, int col) {
        if (row < 0 || row >= R || col < 0 || col >= C) {
            return false;
        }

        return true;
    }

    static void plant(int nowTime) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = nowTime + 3;
                }
            }
        }
    }

    static void explodeAll(int nowTime) {
        ArrayList<Integer>[] explodeList = new ArrayList[2];
        for (int i = 0; i < 2; i++) {
            explodeList[i] = new ArrayList();
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == nowTime) {
                    explodeList[0].add(i);
                    explodeList[1].add(j);
                }
            }
        }

        for (int i = 0; i < explodeList[0].size(); i++) {
            explodeTile(explodeList[0].get(i), explodeList[1].get(i));
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == nowTime) {
                    explodeTile(i, j);
                }
            }
        }
    }

    static void explodeTile(int row, int col) {
        board[row][col] = -1;

        for (int i = 0; i < 4; i++) {
            int nextRow = row + dx[i];
            int nextCol = col + dy[i];
            if (isIndexSafe(nextRow, nextCol)) {
                board[nextRow][nextCol] = -1;
            }
        }
    }
}
