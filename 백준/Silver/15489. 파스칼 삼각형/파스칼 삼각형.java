import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());   //row
        int column = Integer.parseInt(st.nextToken());   //column
        int width = Integer.parseInt(st.nextToken());   //width
        int size = row + width - 1;

        int[][] board = new int[size][size];

        for (int i = 0; i < size; i++) {    //양 끝 1로 초기화
            board[i][0] = 1;
            board[i][i] = 1;
        }

        for (int i = 2; i < size; i++) {
            for (int j = 1; j < i; j++) {
                board[i][j] = board[i - 1][j - 1] + board[i - 1][j];
            }
        }

        int sum = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j <= i; j++) {
                sum +=  board[row - 1 + i][column - 1 + j];
            }
        }

        System.out.println(sum);
    }
}
