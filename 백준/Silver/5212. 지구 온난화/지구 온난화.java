import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static String[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());   //세로 크기
        int C = Integer.parseInt(st.nextToken());   //가로 크기
        Queue<int[]> floodQueue = new LinkedList<>();

        //보드 채우기
        board = new String[R][C];
        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().split("");
        }

        //물에 잠기는 땅 위치 저장
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (isFlood(i, j)) {
                    floodQueue.add(new int[] {i, j});
                }
            }
        }

        //물에 잠기는 땅 변환
        while (!floodQueue.isEmpty()) {
            int[] pos = floodQueue.poll();
            board[pos[0]][pos[1]] = ".";
        }

        //사이즈 측정
        int[] min = new int[] {-1, -1};
        int[] max = new int[] {-1, -1};
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j].equals("X")) {
                    min[0] = min[0] == -1 ? i : Math.min(min[0], i);
                    min[1] = min[1] == -1 ? j : Math.min(min[1], j);
                    max[0] = max[0] == -1 ? i : Math.max(max[0], i);
                    max[1] = max[1] == -1 ? j : Math.max(max[1], j);
                }
            }
        }

        /*for (int i = 0; i < R; i++) {
            System.out.println(String.join("", board[i]));
        }*/

        //System.out.println(min[0] + ", " + min[1] + "부터 " + max[0] + ", " + max[1] + "까지");

        //결과 생성
        StringBuilder sb = new StringBuilder();
        for (int i = min[0]; i <= max[0]; i++) {
            sb.append(String.join("", board[i]), min[1], max[1] + 1).append("\n");
        }

        System.out.println(sb);
    }

    static boolean isFlood(int row, int col) {
        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, -1, 0, 1};

        int waterCount = 0;
        for (int i = 0; i < 4; i++) {
            if (!isIndexSafe(row + dx[i], col + dy[i])) {
                waterCount++;
                continue;
            }

            if (board[row + dx[i]][col + dy[i]].equals(".")) {
                waterCount++;
            }
        }

        return waterCount >= 3;
    }

    static boolean isIndexSafe(int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }

        return true;
    }
}
