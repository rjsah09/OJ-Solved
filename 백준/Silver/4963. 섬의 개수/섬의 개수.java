import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int width;
    static int height;
    static int[][] board;
    static int[] dx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        dx = new int[] {-1, 0, 1};
        String input = br.readLine();
        while (input != null) {
            StringTokenizer st = new StringTokenizer(input);
            height = Integer.parseInt(st.nextToken());
            width = Integer.parseInt(st.nextToken());
            board = new int[width][height];

            if (width == 0 && height == 0) {
                System.out.println(sb);
                return;
            }

            for (int i = 0; i < width; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < height; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int island = 0;
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    if (board[i][j] == 1) {
                        island++;
                        dfs(i, j);
                    }
                }
            }

            sb.append(island).append("\n");
            input = br.readLine();
        }
    }

    static void dfs(int row, int col) {
        board[row][col] = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int nextRow = row + dx[i];
                int nextCol = col + dx[j];

                if (isIndexSafe(nextRow, nextCol) && board[nextRow][nextCol] == 1) {
                    dfs (nextRow, nextCol);
                }
            }
        }
    }

    static boolean isIndexSafe(int row, int col) {
        return row >= 0 && col >= 0 && row < width && col < height;
    }
}
