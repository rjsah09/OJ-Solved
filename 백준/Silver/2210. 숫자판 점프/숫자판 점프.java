import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

//3
//10
//12:02 ~

public class Main {

    static String[][] board;
    static int[] dx;
    static int[] dy;
    static Set<String> resultSet;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new String[5][5];
        dx = new int[]{0, -1, 0, 1};
        dy = new int[]{-1, 0, 1, 0};
        resultSet = new HashSet<>();

        //board 생성
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = st.nextToken();
            }
        }

        //board 탐색
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, "");
            }
        }

        System.out.println(resultSet.size());
    }

    static void dfs(int row, int col, String word) {
        word += board[row][col];

        if (word.length() == 6) {
            resultSet.add(word);
            return;
        }

        for (int i = 0; i < 4; i++ ) {
            int nextRow = row + dx[i];
            int nextCol = col + dy[i];

            if (isIndexSafe(nextRow, nextCol)) {
                dfs(nextRow, nextCol, word);
            }
        }
    }

    static boolean isIndexSafe(int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
    }
}
