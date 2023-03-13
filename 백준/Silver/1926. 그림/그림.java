import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] answer = new int[2];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];

        for(int i = 0; i < n; i++) {
            input = br.readLine();
            st = new StringTokenizer(input);

            for(int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == 1) {  //1을 발견시 bfs 탐색
                    answer[0]++;
                    Queue<Integer[]> q = new LinkedList<>();
                    Integer[] now = {i, j};
                    q.add(now);

                    //bfs
                    int area = 0;
                    while(!q.isEmpty()) {
                        //현재 위치 넓이 더하기
                        Integer[] pos = q.poll();

                        if(board[pos[0]][pos[1]] == 1) {
                            board[pos[0]][pos[1]] = 2;  //visited 체크
                            area++;
                            //주변 체크 -> 1인경우 q.add()
                            for (int k = 1; k <= 4; k++) {
                                int[] nextPos = getPos(k, pos);
                                if (isFineRange(nextPos[0], nextPos[1], n, m)) {
                                    if (board[nextPos[0]][nextPos[1]] == 1) {
                                        q.add(new Integer[]{nextPos[0], nextPos[1]});
                                    }
                                }
                            }
                        }
                    }

                    answer[1] = Math.max(answer[1], area);
                }
            }
        }

        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }

    static int[] getPos(int dir, Integer[] pos) {
        if(dir == 1) {  //상
            return new int[] {pos[0] - 1, pos[1]};
        } else if(dir == 2) {   //우
            return new int[] {pos[0], pos[1] + 1};
        } else if(dir == 3) {   //하
            return new int[] {pos[0] + 1, pos[1]};
         } else if(dir == 4) {   //좌
            return new int[] {pos[0], pos[1] - 1};
        }
        return new int[] {-1, -1};
    }

    static boolean isFineRange(int x, int y, int maxX, int maxY) {
        return (x >= 0 && y >= 0 && x < maxX && y < maxY);
    }
}