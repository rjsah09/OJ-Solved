import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] dx;
    static int[] dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        dx = new int[] {0, 1, 1, 1};
        dy = new int[] {1, 1, 0, -1};

        StringBuilder sb = new StringBuilder();
        while (!line.equals("end")) {
            if (isValid(line)) {
                sb.append("valid");
            } else {
                sb.append("invalid");
            }

            sb.append("\n");
            line = br.readLine();
        }

        System.out.println(sb);
    }

    static boolean isValid(String line) {
        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = line.charAt(3 * i + j);
            }
        }

        int oCount = 0;
        int xCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 'O') {
                    oCount++;
                } else if (board[i][j] == 'X') {
                    xCount++;
                }
            }
        }

        if (oCount + xCount == 9) {
            if (oCount != 4 || xCount != 5) {
                return false;
            }

            if (hasLine(board, 'O')) {
                return false;
            } else if (hasLine(board, 'X')) {
                return true;
            } else {
                return true;
            }
        } else {
            if (hasLine(board, 'O') && hasLine(board, 'X')) {
                return false;
            } else if (hasLine(board, 'O')) {
                if (oCount == xCount) {
                    return true;
                }

                return false;
            } else if (hasLine(board, 'X')) {
                if (oCount + 1== xCount) {
                    return true;
                }

                return false;
            }
        }

        return false;
    }

    static boolean hasLine(char[][] board, char letter) {
        //가로 탐색
        for (int i = 0; i < 3; i++) {
            int count = 0;
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == letter) {
                    count++;
                }
            }

            if (count == 3) {
                return true;
            }
        }

        //세로 탐색
        for (int i = 0; i < 3; i++) {
            int count = 0;
            for (int j = 0; j < 3; j++) {
                if (board[j][i] == letter) {
                    count++;
                }
            }

            if (count == 3) {
                return true;
            }
        }

        //주대각 탐색
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (board[i][i] == letter) {
                count++;
            }
        }
        if (count == 3) {
            return true;
        }

        //부대각 탐색
        count = 0;
        for (int i = 0; i < 3; i++) {
            if (board[i][2 - i] == letter) {
                count++;
            }
        }
        if (count == 3) {
            return true;
        }

        return false;
    }
}