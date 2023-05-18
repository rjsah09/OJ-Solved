import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[][] board = new boolean[101][101];
        for (int i = 0; i < 4; i++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int[] pos1 = new int[]{
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            };
            int[] pos2 = new int[]{
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            };

            for (int j = pos1[0]; j < pos2[0]; j++) {
                for (int k = pos1[1]; k < pos2[1]; k++) {
                    board[j][k] = true;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                if (board[i][j]) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
