import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static int[][] board;
    static boolean[][] visited;
    static boolean[][] dominoUsed;
    static Set<Integer[]> dominoUsedSet;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[8][7];
        visited = new boolean[8][7];
        dominoUsed = new boolean[7][7];
        dominoUsedSet = new HashSet<>();
        result = 0;

        for (int i = 0; i < board.length; i++) {
            String line = br.readLine();
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }

        dfs(0, 0);

        System.out.println(result);
    }

    static void dfs(int row, int col) {
        int nextRow = col == board[0].length - 1 ? row + 1 : row;
        int nextCol = col == board[0].length - 1 ? 0 : col + 1;

        if (row == board.length - 1 && col == board[0].length - 1) {
            //System.out.println("끝 도착, 현재 값 = " + result);
            result++;
            return;
        }

        if (visited[row][col]) {
            //System.out.println("[" + row + ", " + col + "] : 이미 사용된 자리, 다음으로 이동합니다.");
            dfs(nextRow, nextCol);
            return;
        }

        int[] domino = new int[2];
        domino[0] = board[row][col];

        if (isIndexSearchable(row, col, true)) {
            domino[1] = board[row + 1][col];
            if (!containsDomino(domino)) {
                //System.out.println("[" + row + ", " + col + "] : 세로 방향으로 도미노 배치");
                visited[row][col] = true;
                visited[row + 1][col] = true;
                dominoUsed[board[row][col]][board[row + 1][col]] = true;
                dominoUsed[board[row + 1][col]][board[row][col]] = true;
                dfs(nextRow, nextCol);
                visited[row][col] = false;
                visited[row + 1][col] = false;
                dominoUsed[board[row][col]][board[row + 1][col]] = false;
                dominoUsed[board[row + 1][col]][board[row][col]] = false;
            }
        }

        if (isIndexSearchable(row, col, false)) {
            domino[1] = board[row][col + 1];
            if (!containsDomino(domino)) {
                //System.out.println("[" + row + ", " + col + "] : 가로 방향으로 도미노 배치");
                visited[row][col + 1] = true;
                visited[row][col] = true;
                dominoUsed[board[row][col]][board[row][col + 1]] = true;
                dominoUsed[board[row][col + 1]][board[row][col]] = true;
                dfs(nextRow, nextCol);
                visited[row][col] = false;
                visited[row][col + 1] = false;
                dominoUsed[board[row][col]][board[row][col + 1]] = false;
                dominoUsed[board[row][col + 1]][board[row][col]] = false;
            }
        }

        visited[row][col] = false;
    }

    static boolean isIndexSafe(int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }

        return true;
    }

    static boolean isIndexSearchable(int row, int col, boolean isVertical) {
        //현재 인덱스 탐색 가능 검사
        if (!isIndexSafe(row, col) || visited[row][col]) {
            return false;
        }

        int nextRow = row;
        int nextCol = col;
        if (isVertical) {
            nextRow++;
        } else {
            nextCol++;
        }

        //다음 인덱스 탐색 가능 검사
        if (!isIndexSafe(nextRow, nextCol) || visited[nextRow][nextCol]) {
            return false;
        }

        int dominoNum1 = board[row][col];
        int dominoNum2 = board[nextRow][nextCol];
        if (dominoUsed[dominoNum1][dominoNum2]) {
            return false;
        }

        return true;
    }

    static boolean containsDomino(int[] domino) {
        int[] reversed = new int[]{domino[1], domino[0]};

        if (dominoUsedSet.contains(domino) || dominoUsedSet.contains(reversed)) {
            return true;
        }

        return false;
    }

}