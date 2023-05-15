import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int size = Integer.parseInt(line);
        int[][] board = new int[size][size];

        for (int i = 0; i < size; i++) {
            line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            for (int j = 0; j < size; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][] dp = new long[size][size];
        dp[0][0] = 1L;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == size - 1 && j == size - 1) {
                    break;
                }

                int length = board[i][j];   //가야 하는 거리

                if (isIndexSafe(board, i + length, j)) {
                    dp[i + length][j] += dp[i][j];
                }

                if (isIndexSafe(board, i, j + length)) {
                    dp[i][j + length] += dp[i][j];
                }
            }
        }

        System.out.println(dp[size - 1][size - 1]);
    }

    public static boolean isIndexSafe(int[][] board, int posI, int posJ) {

        if (posI < 0 || posI >= board.length || posJ < 0 || posJ >= board.length) {
            return false;
        }

        return true;
    }
}