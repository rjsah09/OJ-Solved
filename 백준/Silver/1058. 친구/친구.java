import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1:10

//2-친구를 구하는 방법
//서로가 친구인 경우
//서로 같은 사람과 친구인 경우

public class Main {

    static int N;
    static String[][] board;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new String[N][N];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().split("");
        }

//        for (int i = 0; i < N; i++ ) {
//            String result = "";
//            for (int j = 0; j < N; j++) {
//                result += board[i][j] + " ";
//            }
//            System.out.println(result);
//        }

        int max = 0;
        for (int i = 0; i < N; i++) {           //i와
            int friends = 0;
            for (int j = 0; j < N; j++) {       //j가 친구인 경우
                if (i == j) {
                    continue;
                }

                if (board[i][j].equals("Y")) {
                    friends++;
                } else {
                    for (int k = 0; k < N; k++) {
                        if (i == k || j == k) {
                            continue;
                        }

                        if (board[i][k].equals("Y") && board[j][k].equals("Y")) {
                            friends++;
                            break;
                        }
                    }
                }
            }

            max = Math.max(max, friends);
        }

        System.out.println(max);
    }
}