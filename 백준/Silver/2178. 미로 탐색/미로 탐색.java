import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[][] maze;
    static boolean[][] visited;
    static int n, m;

    public static void main(String[] args) throws IOException {
        makeMaze();

        bfs();
    }

    static void makeMaze() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        maze = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }

        br.close();
    }

    static int[] getPos(int[] pos, int dir) {
        int[] newPos = new int[3];
        switch(dir) {
            case 1:
                newPos[0] = pos[0] - 1;
                newPos[1] = pos[1];
                break;
            case 2:
                newPos[0] = pos[0];
                newPos[1] = pos[1] + 1;
                break;
            case 3:
                newPos[0] = pos[0] + 1;
                newPos[1] = pos[1];
                break;
            case 4:
                newPos[0] = pos[0];
                newPos[1] = pos[1] - 1;
                break;
        }
        return newPos;
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[2]);

        while(!q.isEmpty()) {
            int[] pos = q.poll();
            visited[pos[0]][pos[1]] = true;

            if(pos[0] == n - 1 && pos[1] == m - 1) {
                System.out.println(maze[pos[0]][pos[1]]);
                return;
            }

            for(int i = 1; i <= 4; i++) {    //현재 위치에서 방향별로 노드 탐색
                int[] nextNode = getPos(pos, i);
                if(nextNode[0] >= 0 && nextNode[0] < n && nextNode[1] >= 0 && nextNode[1] < m) {
                    if (!visited[nextNode[0]][nextNode[1]] && maze[nextNode[0]][nextNode[1]] == 1) {
                        q.offer(nextNode);
                        maze[nextNode[0]][nextNode[1]] = maze[pos[0]][pos[1]] + 1;
                    }
                }
            }
        }
    }
}