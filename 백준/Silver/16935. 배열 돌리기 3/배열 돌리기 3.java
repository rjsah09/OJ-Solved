import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int rotationNo = Integer.parseInt(st.nextToken());
            switch (rotationNo) {
                case 1:
                    board = rotation1(board);
                    break;
                case 2:
                    board = rotation2(board);
                    break;
                case 3:
                    board = rotation3(board);
                    break;
                case 4:
                    board = rotation4(board);
                    break;
                case 5:
                    board = rotation5(board);
                    break;
                case 6:
                    board = rotation6(board);
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                sb.append(board[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static int[][] rotation1(int[][] arr) { //상하반전
        for (int i = 0; i < arr.length / 2; i++) {
            int [] swap = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = swap;
        }

        return arr;
    }

    static int[][] rotation2(int[][] arr) { //좌우반전
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length / 2; j++) {
                int swap = arr[i][j];
                arr[i][j] = arr[i][arr[i].length - j - 1];
                arr[i][arr[i].length - j - 1] = swap;
            }
        }

        return arr;
    }

    static int[][] rotation3(int[][] arr){
        int[][] newArr = new int[arr[0].length][arr.length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                newArr[j][arr.length - i - 1] = arr[i][j];
            }
        }

        return newArr;
    }

    static int[][] rotation4(int[][] arr){
        int[][] newArr = new int[arr[0].length][arr.length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                newArr[arr[0].length - j - 1][i] = arr[i][j];
            }
        }

        return newArr;
    }

    static int[][] rotation5(int[][] arr) {
        int[][] swap = new int[arr.length / 2][arr[0].length / 2];

        for (int i = 0; i < arr.length / 2; i++) {
            for (int j = 0; j < arr[0].length / 2; j++) {
                swap[i][j] = arr[i][j];
            }
        }

        for (int i = 0; i < arr.length / 2; i++) {
            for (int j = 0; j < arr[0].length / 2; j++) {
                int tmp = arr[i][j + arr[0].length / 2];
                arr[i][j + arr[0].length / 2] = swap[i][j];
                swap[i][j] = tmp;
            }
        }

        for (int i = 0; i < arr.length / 2; i++) {
            for (int j = 0; j < arr[0].length / 2; j++) {
                int tmp = arr[i + arr.length / 2][j + arr[0].length / 2];
                arr[i + arr.length / 2][j + arr[0].length / 2] = swap[i][j];
                swap[i][j] = tmp;
            }
        }

        for (int i = 0; i < arr.length / 2; i++) {
            for (int j = 0; j < arr[0].length / 2; j++) {
                int tmp = arr[i + arr.length / 2][j];
                arr[i + arr.length / 2][j] = swap[i][j];
                swap[i][j] = tmp;
            }
        }

        for (int i = 0; i < arr.length / 2; i++) {
            for (int j = 0; j < arr[0].length / 2; j++) {
                int tmp = arr[i][j];
                arr[i][j] = swap[i][j];
                swap[i][j] = tmp;
            }
        }

        return arr;
    }

    static int[][] rotation6(int[][] arr) {
        int[][] swap = new int[arr.length / 2][arr[0].length / 2];

        for (int i = 0; i < arr.length / 2; i++) {      //swap = 1;
            for (int j = 0; j < arr[0].length / 2; j++) {
                swap[i][j] = arr[i][j];
            }
        }

        for (int i = 0; i < arr.length / 2; i++) {      //4
            for (int j = 0; j < arr[0].length / 2; j++) {
                int tmp = arr[i + arr.length / 2][j];
                arr[i + arr.length / 2][j] = swap[i][j];
                swap[i][j] = tmp;
            }
        }

        for (int i = 0; i < arr.length / 2; i++) {      //3
            for (int j = 0; j < arr[0].length / 2; j++) {
                int tmp = arr[i + arr.length / 2][j + arr[0].length / 2];
                arr[i + arr.length / 2][j + arr[0].length / 2] = swap[i][j];
                swap[i][j] = tmp;
            }
        }

        for (int i = 0; i < arr.length / 2; i++) {      //2
            for (int j = 0; j < arr[0].length / 2; j++) {
                int tmp = arr[i][j + arr[0].length / 2];
                arr[i][j + arr[0].length / 2] = swap[i][j];
                swap[i][j] = tmp;
            }
        }

        for (int i = 0; i < arr.length / 2; i++) {      ///1
            for (int j = 0; j < arr[0].length / 2; j++) {
                int tmp = arr[i][j];
                arr[i][j] = swap[i][j];
                swap[i][j] = tmp;
            }
        }

        return arr;
    }
}
