import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] paper;   //1은 파란색, 0은 횐색
    static int[] colorCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        colorCount = new int[2];

        paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int color = Integer.parseInt(st.nextToken());
                paper[i][j] = color;
            }
        }

        paperCheck(0, 0, N);
        System.out.println(colorCount[0]);
        System.out.println(colorCount[1]);
    }

    static void paperCheck(int posI, int posJ, int size) {
        int color = paper[posI][posJ];
        if (isAllSameColor(posI, posJ, size, color)) {
            colorCount[color]++;
            return;
        }

        int half = size / 2;
        paperCheck(posI, posJ, half);
        paperCheck(posI, posJ + half, half);
        paperCheck(posI + half, posJ, half);
        paperCheck(posI + half, posJ + half, half);
    }

    static boolean isAllSameColor(int posI, int posJ, int size, int color) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (paper[posI + i][posJ + j] != color) {
                    return false;
                }
            }
        }

        return true;
    }
}