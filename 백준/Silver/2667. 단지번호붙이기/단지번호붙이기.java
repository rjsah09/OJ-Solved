import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[][] village;
    static boolean[][] visited;
    static int n;
    static ArrayList<Integer> houses = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        village = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                village[i][j] = line.charAt(j) - '0';
            }
        }

        int vn = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && village[i][j] != 0) {  //새로운 단지 발견
                    houses.add(0);
                    bfs(new int[]{i, j}, vn++);
                }
            }
        }

        Collections.sort(houses);

        System.out.println(vn);
        for(int i = 0; i < vn; i++)
            System.out.println(houses.get(i));
    }

    public static boolean outOfMap(int[] pos) {
        if(pos[0] < 0 || pos[0] >= n || pos[1] < 0 || pos[1] >= n)
            return false;
        return true;
    }

    public static int[] getPos(int[] nowPos, int dir) {
        int[] nextPos = new int[2];

        switch (dir) {
            case 1 :
                nextPos[0] = nowPos[0] - 1;
                nextPos[1] = nowPos[1];
                break;
            case 2:
                nextPos[0] = nowPos[0];
                nextPos[1] = nowPos[1] + 1;
                break;
            case 3:
                nextPos[0] = nowPos[0] + 1;
                nextPos[1] = nowPos[1];
                break;
            case 4:
                nextPos[0] = nowPos[0];
                nextPos[1] = nowPos[1] - 1;
                break;
        }

        return nextPos;
    }

    public static void bfs(int[] pos, int vn) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(pos);

        while(!q.isEmpty()) {
            int[] nowPos = q.poll();
            if(!visited[nowPos[0]][nowPos[1]]) {
                visited[nowPos[0]][nowPos[1]] = true;
                houses.set(vn, houses.get(vn) + 1);

                for (int i = 1; i <= 4; i++) {
                    int[] nextPos = getPos(nowPos, i);
                    if (outOfMap(nextPos) && !visited[nextPos[0]][nextPos[1]] && village[nextPos[0]][nextPos[1]] != 0) {
                        q.offer(nextPos);
                    }
                }
            }
        }
    }
}
