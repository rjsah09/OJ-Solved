import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int[][] board;
    static ArrayList<Integer>[] emptyAreaLists; //빈공간 정보

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[9][9];
        emptyAreaLists = new ArrayList[] {new ArrayList<>(), new ArrayList<>()};

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 0) {
                    emptyAreaLists[0].add(i);
                    emptyAreaLists[1].add(j);
                }
                board[i][j] = num;
            }
        }

        sb = new StringBuilder();
        for (int i = 1; i <= 9; i++) {
            dfs(0, i);
        }

        System.out.println(sb);
    }

    static void dfs(int depth, int num) {
        int row = emptyAreaLists[0].get(depth);
        int col = emptyAreaLists[1].get(depth);

        if (!isNumberSafe(row, col, num)) {
            board[row][col] = 0;
            return;
        }

        board[row][col] = num;

        if (depth == emptyAreaLists[0].size() - 1) {
            if (sb.length() == 0) {
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        sb.append(board[i][j] + " ");
                    }
                    sb.append("\n");
                }
            }

            return;
        }

        for (int i = 1; i <= 9; i++) {
            dfs (depth + 1, i);
        }

        board[row][col] = 0;
    }

    static boolean isNumberSafe(int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }

        int blockRow = row / 3;
        int blockCol = col / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[blockRow * 3 + i][blockCol * 3 + j] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}
