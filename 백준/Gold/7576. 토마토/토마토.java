import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        StringTokenizer st = new StringTokenizer(input);
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];

        for(int i = 0; i < n; i++) {
            input = br.readLine();
            st = new StringTokenizer(input);
            for(int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> q = new LinkedList<>();    //[x값, y값, 익은날짜]
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == 1) {
                    q.add(new int[] {i, j});
                }
            }
        }

        while(!q.isEmpty()) {
            int[] info = q.poll();

            for(int i = 1; i <= 4; i++) {
                int[] nextInfo = getNextInfo(i, info);
                if(isFineRange(nextInfo[0], nextInfo[1], n, m)) {
                    if(board[nextInfo[0]][nextInfo[1]] == 0) {
                        q.add(new int[] {nextInfo[0], nextInfo[1]});
                        board[nextInfo[0]][nextInfo[1]] = board[info[0]][info[1]] + 1;
                    }
                }
            }
        }

        System.out.println(getMaxDay(board));
    }

    static int getMaxDay(int[][] board) {
        int max = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 0)
                    return -1;
                max = Math.max(max, board[i][j]);
            }
        }
        return max - 1;
    }

    static int[] getNextInfo(int dir, int[] info) {
        if(dir == 1) {  //상
            return new int[] {info[0] - 1, info[1]};
        } else if(dir == 2) {   //우
            return new int[] {info[0], info[1] + 1};
        } else if(dir == 3) {   //하
            return new int[] {info[0] + 1, info[1]};
        } else if(dir == 4) {   //좌
            return new int[] {info[0], info[1] - 1};
        }
        return new int[] {-1, -1};
    }

    static boolean isFineRange(int x, int y, int maxX, int maxY) {
        if(x >= 0 && x < maxX && y >= 0 && y < maxY)
            return true;
        return false;
    }
}