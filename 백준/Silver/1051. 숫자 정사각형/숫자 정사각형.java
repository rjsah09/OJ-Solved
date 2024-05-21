import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//8:45 ~ 9:00
public class Main {
    static int N;
    static int M;
    static int[][] board;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        max = 0;

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(input.substring(j, j + 1));
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                recur(i, j, 0);
            }
        }

        System.out.println(max);
    }

    static void recur(int row, int col, int size) {
        int destRow = row + size;
        int destCol = col + size;

        if (board[row][col] == board[row][destCol]
                && board[destRow][col] == board[destRow][destCol]
                && board[row][col] == board[destRow][col]) {
            //System.out.println(row + ", " + col + "에서 " + size + "만큼 해서 " + size * size);
            max = Math.max(max, (int) Math.pow(size + 1, 2));
        }

        if (isIndexSafe(row + size + 1, col + size + 1)) {
            recur(row, col, size + 1);
        }
    }

    static boolean isIndexSafe(int row, int col) {
        return row >= 0 && row < N && col >= 0 && col < M;
    }
}
