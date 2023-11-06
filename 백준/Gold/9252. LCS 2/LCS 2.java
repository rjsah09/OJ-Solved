import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        int[][] board = new int[a.length() + 1][b.length() + 1];
        for (int i = 1; i <= a.length(); i++) {
            char aCh = a.charAt(i - 1);
            for (int j = 1; j <= b.length(); j++) {
                char bCh = b.charAt(j - 1);
                board[i][j] = aCh == bCh ? board[i - 1][j - 1] + 1 : Math.max(board[i - 1][j], board[i][j - 1]);
            }
        }

        int max = board[a.length()][b.length()];
        int row = a.length();
        int col = b.length();

        System.out.println(max);
        char[] letters = new char[max];
        while (max > 0) {
            if (board[row][col] == board[row - 1][col]) {
                row--;
            } else if (board[row][col] == board[row][col - 1]) {
                col--;
            } else {
                letters[max - 1] = b.charAt(col - 1);
                max--;
                row--;
                col--;
            }
        }
        System.out.println(String.valueOf(letters));
    }
}