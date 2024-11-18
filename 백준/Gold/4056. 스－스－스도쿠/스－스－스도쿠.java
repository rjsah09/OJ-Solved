import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//기존의 방식: 1~9의 경우를 모두 넣고 확인
//새로운 방식: 해당 위치의 행과 열, 블록을 체크해 가능한 경우만 탐색

public class Main {

    static int N;
    static int[][] board;
    static BufferedReader br;
    static int[][] blanks;
    static boolean[] answer;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        answer = new boolean[N];
        blanks = new int[5][2];

        for (int i = 0; i < N; i++) {
            board = makeBoard();

            for (int j = 1; j <= 9; j++) {

                board[blanks[0][0]][blanks[0][1]] = j;
                dfs(0, i);
                if (answer[i]) {
                    break;
                }
                board[blanks[0][0]][blanks[0][1]] = 0;
            }

            if (answer[i]) {
                for (int j = 0; j < 9; j++) {
                    StringBuilder line = new StringBuilder();
                    for (int k = 0; k < 9; k++) {
                        line.append(board[j][k]);
                    }
                    System.out.println(line);
                }
            } else {
                System.out.println("Could not complete this grid.");
            }
            System.out.println();
        }

    }

    static int[][] makeBoard() throws IOException {
        int[][] board = new int[9][9];

        int count = 0;
        for (int i = 0; i < 9; i++) {
            String input = br.readLine();
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(input.substring(j, j + 1));
                if (board[i][j] == 0) {
                    blanks[count] = new int[] {i, j};
                    count++;
                }
            }
        }

        return board;
    }

    static void dfs(int depth, int n) {
        if (answer[n]) {
            return;
        }

        if (depth == 4) {
            if (checkSudoku()) {
                answer[n] = true;
            }

            return;
        }

        for (int i = 1; i <= 9; i++) {
            int row = blanks[depth + 1][0];
            int col = blanks[depth + 1][1];
            if (isNumberPossible(row, col, i)) {
                board[row][col] = i;
                dfs(depth + 1, n);
                if (answer[n]) {
                    return;
                }
                board[row][col] = 0;
            }
        }
    }

    static boolean isNumberPossible(int row, int col, int number) {
        return checkLine(row, true, number) && checkLine(col, false, number) && checkBlock(row, col, number);
    }

    static boolean checkLine(int line, boolean isRow, int number) {
        for (int i = 0; i < 9; i++) {
            if (isRow) {
                if (board[line][i] == number) {
                    return false;
                }
            } else {
                if (board[i][line] == number) {
                    return false;
                }
            }
        }

        return true;
    }

    static boolean checkBlock(int row, int col, int number) {
        int startRow = row - row % 3;
        int startCol = col - col % 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == number) {
                    return false;
                }
            }
        }

        return true;
    }

    static boolean checkSudoku() {
        for (int i = 0; i < 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (checkLine(i, true, j) || checkLine(i, false, j)) {
                    return false;
                }
            }
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                for (int k = 1; k <= 9; k++) {
                    if (checkBlock(i, j, k)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

}
