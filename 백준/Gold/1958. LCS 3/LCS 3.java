import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();

        int[][][] board = new int[a.length() + 1][b.length() + 1][c.length() + 1];

        for (int i = 1; i <= a.length(); i++) {
            char aCh = a.charAt(i - 1);
            for (int j = 1; j <= b.length(); j++) {
                char bCh = b.charAt(j - 1);
                for (int k = 1; k <= c.length(); k++) {
                    char cCh = c.charAt(k - 1);
                    board[i][j][k] = (aCh == bCh) && (bCh == cCh) ? board[i - 1][j - 1][k - 1] + 1 : Math.max(board[i - 1][j][k], Math.max(board[i][j - 1][k], board[i][j][k - 1]));
                }
            }
        }

        System.out.println(board[a.length()][b.length()][c.length()]);
    }
}
