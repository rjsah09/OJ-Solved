import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int secondary = pool(0, 0, N);

        System.out.println(secondary);
    }

    static int pool(int rowStart, int colStart,int size) {
        if (size == 1) {
            return board[rowStart][colStart];
        }

        ArrayList<Integer> sortList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            int nextRowStart = rowStart + i * size / 2;
            for (int j = 0; j < 2; j++) {
                int nextColStart = colStart + j * size / 2;
                sortList.add(pool(nextRowStart, nextColStart, size / 2));
            }
        }

        Collections.sort(sortList, Collections.reverseOrder());
        return sortList.get(1);
    }
}
