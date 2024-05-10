import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static long[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //row
        int M = Integer.parseInt(st.nextToken());   //col
        board = new long[N][M];
        long[][] dp = new long[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0] = Arrays.copyOf(board[0], M);

        int[] dy = {-1, 0, 1};
        for (int i = 1; i < N; i++) {   //도착하려는 단계
            for (int j = 0; j < M; j++) {   //단계의 계단 위치
                if (board[i][j] == 0) {
                    continue;
                }

                for (int k = 0; k < dy.length; k++) {
                    int beforeRow = i - 1;
                    int beforeCol = j + dy[k];
                    if (isIndexSafe(beforeRow, beforeCol)) {
                        dp[i][j] += dp[beforeRow][beforeCol] % 1_000_000_007;
                    }
                }
                dp[i][j] %= 1_000_000_007;
            }
        }

        long result = 0;
        for (int i = 0; i < M; i++) {
            if (dp[N - 1][i] != 0) {
                result += dp[N - 1][i] % 1_000_000_007;
            }
        }

        System.out.println(result % 1_000_000_007);
    }

    static boolean isIndexSafe(int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
    }
}