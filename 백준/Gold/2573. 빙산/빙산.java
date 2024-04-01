import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] board;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   //행의 개수
        M = Integer.parseInt(st.nextToken());   //열의 개수
        board = new int[N][M];
        int result = 0;

        //보드 만들기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int yearCount = 0;
        int icebergCount = 1;
        while (icebergCount == 1) {
            yearCount++;
            icebergCount = 0;
            visited = new boolean[N][M];

            //탐색
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visited[i][j] && board[i][j] > 0) {
                        //System.out.println(yearCount + "년 에 " + i + ", " + j + "에서 탐색 시작");
                        icebergCount++;
                        dfs(i, j);
                    }
                }
            }

            if (icebergCount == 0) {
                System.out.println(0);
                return;
            }
        }

        if (yearCount > 0) {
            System.out.println(yearCount - 1);
        } else {
            System.out.println(0);
        }
    }

    static void dfs(int row, int col) {
        if(visited[row][col]) {
            return;
        }

        visited[row][col] = true;

        int[] dx = new int[]{0, -1, 0, 1};
        int[] dy = new int[]{-1, 0, 1, 0};

        int waterCount = 0;
        List<int[]> travel = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int nextRow = row + dx[i];
            int nextCol = col + dy[i];

            if (!visited[nextRow][nextCol] && board[nextRow][nextCol] > 0 && isIndexSafe(nextRow, nextCol)) {
                travel.add(new int[] {nextRow, nextCol});
            } else if (board[nextRow][nextCol] == 0) {
                waterCount++;
            }
        }

        for (int i = 0; i < travel.size(); i++) {
            int[] next = travel.get(i);
            dfs(next[0], next[1]);
        }

        //System.out.println(row + ", " + col + ", waterCount = " + waterCount);
        board[row][col] -= waterCount;
        if (board[row][col] < 0) {
            board[row][col] = 0;
        }
    }

    static void print() {
        for (int i = 0; i < N; i++) {
            String str = "";
            for (int j = 0; j < M; j++) {
                str += board[i][j] + " ";
            }
            System.out.println(str);
        }
    }

    static boolean isIndexSafe(int row, int col) {
        return row > 0 && row < N && col > 0 && col < M;
    }
}
