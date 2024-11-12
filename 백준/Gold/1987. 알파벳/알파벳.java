import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int R;
    static int C;
    static Set<Character> characters;
    static char[][] board;
    static int[] dx;
    static int[] dy;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        characters = new HashSet<>();
        dx = new int[] {0, -1, 0, 1};
        dy = new int[] {-1, 0, 1, 0};

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        answer = 0;
        characters.add(board[0][0]);
        dfs(0, 0, 1);
        characters.remove(board[0][0]);


        System.out.println(answer);
    }

    static boolean isIndexSafe(int row, int col) {
        return row >= 0 && row < R && col >= 0 && col < C;
    }

    static void dfs(int row, int col, int depth) {
        answer = Math.max(answer, depth);

            for (int i = 0; i < dx.length; i++) {
                int nextRow = row + dx[i];
                int nextCol = col + dy[i];

                if (isIndexSafe(nextRow, nextCol) && !characters.contains(board[nextRow][nextCol])) {
                    characters.add(board[nextRow][nextCol]);
                    dfs(nextRow, nextCol, depth + 1);
                    characters.remove(board[nextRow][nextCol]);
                }
        }
    }
}
