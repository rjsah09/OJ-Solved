import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//08:51 ~ 09:00
//09:49 ~ 10:02

public class Main {

    static int N;
    static int M;
    static String[][] board;
    static int[] dx;
    static int[] dy;
    static int area;
    static int bPower;
    static int wPower;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        board = new String[N][M];
        dx = new int[] {0, -1, 0, 1};
        dy = new int[] {-1, 0, 1, 0};

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().split("");
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j].equals("B") || board[i][j].equals("W")) {
                    String letter = board[i][j];
                    area = 0;
                    dfs(i, j, letter);

                    if (letter.equals("B")) {
                        bPower += area * area;
                    } else if (letter.equals("W")) {
                        wPower += area * area;
                    }
                }
            }
        }

        System.out.println(wPower + " " + bPower);
    }

    static void dfs(int row, int col, String letter) {
        area++;
        board[row][col] = "N";

        for (int i = 0; i < 4; i++) {
            int nextRow = row + dx[i];
            int nextCol = col + dy[i];

            if (isIndexSafe(nextRow, nextCol) && letter.equals(board[nextRow][nextCol])) {
                dfs(nextRow, nextCol, letter);
            }
        }
    }

    static boolean isIndexSafe(int row, int col) {
        return row >= 0 && col >= 0 && row < N && col < M;
    }

}
