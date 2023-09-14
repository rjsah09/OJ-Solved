import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int SIZE = 10;
    static int haveToAttach;
    static boolean[][] board;
    static int result;
    static int[] leftPapers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new boolean[SIZE][SIZE];
        result = 81;
        leftPapers = new int[]{0, 5, 5, 5, 5, 5};

        haveToAttach = 0;
        for (int i = 0; i < SIZE; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < SIZE; j++) {
                if (st.nextToken().equals("1")) {
                    haveToAttach++;
                    board[i][j] = true;
                }
            }
        }

        dfs(0, 0, 0);

        if (result == 81) {
            result = -1;
        }

        System.out.println(result);
    }

    static void dfs(int row, int col, int paperCount) {
        //다음 위치 선정
        int nextRow = col == SIZE - 1 ? row + 1 : row;
        int nextCol = col == SIZE - 1 ? 0 : col + 1;

        if (nextRow >= SIZE) {
            if (board[row][col]) {
                if (leftPapers[1] <= 0) {
                    return;
                } else {
                    paperCount++;
                }
            }
            result = result == 0 ? result : Math.min(result, paperCount);
            return;
        }

        if (result <= paperCount) {
            return;
        }

        if (board[row][col]) {
            for (int i = 5; i >= 1; i--) {
                boolean attachable = isAttachable(row, col, i);
                //종이 붙임
                if (isAttachable(row, col, i)) {
                    leftPapers[i]--;
                    makeAreaTorF(row, col, i, false);

                    dfs(nextRow, nextCol, paperCount + 1);

                    leftPapers[i]++;
                    makeAreaTorF(row, col, i, true);
                }
            }
        } else {
            dfs(nextRow, nextCol, paperCount);
        }

    }

    public static boolean isIndexSafe(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE;
    }

    public static void makeAreaTorF(int row, int col, int length, boolean bool) {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                board[row + i][col + j] = bool;
            }
        }
    }

    public static boolean isAttachable(int row, int col, int length) {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (!isIndexSafe(row + i, col + j) || !board[row + i][col + j]) {
                    return false;
                }
            }
        }

        return leftPapers[length] > 0;
    }

}
