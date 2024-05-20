import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//8:45 ~ 9:00
//11:38 ~

public class Main {

    static int N;
    static int M;
    static int[][] board;
    static int min;
    static int[] dx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        min = Integer.MAX_VALUE;
        dx= new int[] {-1, 0, 1};

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            dfs(0, i, 0, 0);
        }

        System.out.println(min);

    }

    static void dfs(int row, int col, int fuel, int dir) {
        fuel += board[row][col];

        if (row == N - 1) {
            min = Math.min(min, fuel);
            return;
        }

        for (int i = 0; i < dx.length; i++) {
            if (isIndexSafe(row + 1, col + dx[i]) && (i != dir || row == 0)) {
                dfs(row + 1, col + dx[i], fuel, i);
            }
        }
    }

    static  boolean isIndexSafe(int row, int col) {
        return row >= 0 && row < N && col >= 0 && col < M;
    }
}
