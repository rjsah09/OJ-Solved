import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int[][] board;
    static ArrayList<Integer>[] emptyAreaLists; //빈공간 정보
    static boolean found;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[9][9];
        emptyAreaLists = new ArrayList[] {new ArrayList<>(), new ArrayList<>()};
        found = false;

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

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 9; i++) {
            if (isNumberSafe(0, i) && !found) {
                dfs(0, i);
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(board[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int depth, int num) {
        int row = emptyAreaLists[0].get(depth);
        int col = emptyAreaLists[1].get(depth);
        board[row][col] = num;

        if (depth == emptyAreaLists[0].size() - 1) {
            found = true;
            return;
        }

        if (!found) {
            for (int i = 1; i <= 9; i++) {
                if (isNumberSafe(depth + 1, i)) {
                    dfs(depth + 1, i);
                }
            }
        }

        if (!found) {
            board[row][col] = 0;
        }
    }

    static boolean isNumberSafe(int depth, int num) {
        int row = emptyAreaLists[0].get(depth);
        int col = emptyAreaLists[1].get(depth);

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
