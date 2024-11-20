import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        int answer = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(line.substring(j, j + 1));
                if (board[i][j] == 1) {
                    answer = 1;
                }
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if (board[i][j] > 0) {
                    int maxLength;

                    if (board[i -1][j] == board[i][j - 1] && board[i - 1][j - 1] < board[i - 1][j]) {
                        maxLength = board[i - 1][j - 1] + 1;
                    } else {
                        maxLength = Math.min(board[i -1][j], board[i][j - 1]) + 1;
                    }

                    board[i][j] = maxLength;
                }

                answer = Math.max(answer, board[i][j]);
            }
        }

        System.out.println(answer * answer);
    }
}