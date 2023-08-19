import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static char[][] board;
    static boolean[][] visited;
    static int[] dx;
    static int[] dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        board = new char[N][N];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        dx = new int[]{-1, 0, 1, 0};
        dy = new int[]{0, -1, 0, 1};

        //일반 탐색
        int normalSectionCount = 0;
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    normalSectionCount++;
                    dfs(i, j, board[i][j], false);
                }
            }
        }

        //색약 탐색
        int weaknessSectionCount = 0;
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, board[i][j], true);
                    weaknessSectionCount++;
                }
            }
        }

        System.out.println(normalSectionCount + " " + weaknessSectionCount);
    }

    static void dfs(int posI, int posJ, char color, boolean isWeakness) {
        visited[posI][posJ] = true;

        for (int i = 0; i < 4; i++) {
            int newPosI = posI + dx[i];
            int newPosJ = posJ + dy[i];

            if (isIndexSafe(newPosI, newPosJ) && !visited[newPosI][newPosJ] && isSameColor(color, board[newPosI][newPosJ], isWeakness)) {
                dfs(newPosI, newPosJ, color, isWeakness);
            }
        }
    }

    static boolean isIndexSafe(int posI, int posJ) {
        if (posI >= 0 && posI < board.length && posJ >= 0 && posJ < board.length) {
            return true;
        }

        return false;
    }

    static boolean isSameColor(char color1, char color2, boolean isWeakness) {
        if (isWeakness && ((color1 == 'R' && color2 == 'G') || (color1 == 'G' && color2 == 'R'))) {
            return true;
        }

        return color1 == color2;
    }
}
