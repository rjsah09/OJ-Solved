import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());

            int[][] arr = new int[N][N];
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            rotate(arr, D);
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    sb.append(arr[j][k] + " ");
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    static void rotate(int[][] arr, int d) {
        int repeatCount = (d % 360) / 45;

        if (repeatCount < 0) {
            repeatCount += 8;
        }

        for (int i = 0; i < Math.abs(repeatCount % 45); i++) {
            clockwise(arr);
        }
    }

    static void clockwise(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            //주대각선을 가운데 열로
            int tmp = arr[i][arr.length / 2];   //tmp = 주 대각선
            arr[i][arr.length / 2] = arr[i][i]; //o

            //가운데 열을 부대각선으로
            int subTmp = arr[i][arr.length - 1 - i];
            arr[i][arr.length - 1 - i] = tmp;   //o

            //부대각선을 가운데 행으로
            tmp = arr[arr.length / 2][arr.length - 1 - i];
            arr[arr.length / 2][arr.length - 1 - i] = subTmp;

            //가운데 행을 주대각선으로
            arr[i][i] = tmp;
        }

        for (int i = 0; i < arr.length / 2; i++) {
            int tmp = arr[i][i];
            arr[i][i] =  arr[arr.length - 1 - i][arr.length - 1 - i];
            arr[arr.length - 1 - i][arr.length - 1 - i] = tmp;
        }
    }
}