import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//15:54 ~ 15:58
//18:09 ~


public class Main {

    static int N;
    static String[][] board;
    static int[] dx;
    static int[] dy;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new String[N][N];
        max = 0;

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().split("");
        }

        dx = new int[] {0, -1, 0, 1};
        dy = new int[] {-1, 0, 1, 0};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k  = 0; k < 4; k++) {
                    int swapRow = i + dx[k];
                    int swapCol = j + dy[k];

                    if (!isIndexSafe(swapRow, swapCol)) {
                        continue;
                    }

                    swap(i, j, swapRow, swapCol);
                    max = Math.max(max, getMax());
                    swap(i, j, swapRow, swapCol);
                }
            }
        }

        System.out.println(max);
    }

    public static void swap(int row, int col, int swapRow, int swapCol) {
        String tmp = board[row][col];
        board[row][col] = board[swapRow][swapCol];
        board[swapRow][swapCol] = tmp;
    }

    public static int getMax() {
        int maxCandy = 0;

        //행 따라 체크
        for (int i = 0; i < N; i++) {       //열
            int lineCandy = 1;
            String prev = board[0][i];
            for (int j = 1; j < N; j++) {
                if (board[j][i].equals(prev)) {
                    lineCandy++;
                } else {
                    prev = board[j][i];
                    maxCandy = Math.max(maxCandy, lineCandy);
                    lineCandy = 1;
                }
            }

            maxCandy = Math.max(maxCandy, lineCandy);
        }

        //열 따라 체크
        for (int i = 0; i < N; i++) {       //열
            int lineCandy = 1;
            String prev = board[i][0];
            for (int j = 1; j < N; j++) {
                if (board[i][j].equals(prev)) {
                    lineCandy++;
                } else {
                    prev = board[i][j];
                    maxCandy = Math.max(maxCandy, lineCandy);
                    lineCandy = 1;
                }
            }

            maxCandy = Math.max(maxCandy, lineCandy);
        }

        return maxCandy;
    }

    static boolean isIndexSafe(int row, int col) {
        return row >= 0 && row < N && col >= 0 && col < N;
    }

}
