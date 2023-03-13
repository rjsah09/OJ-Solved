import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());
        map = new int[n][n];

        fillSnail();
        printStat(target);
    }

    static void fillSnail() {
        int n = map.length;
        int center = n / 2;
        map[center][center] = 1;

        for(int i = 0; i < center + 1; i++) {
            int value = (int)Math.pow((map.length - i * 2), 2);
            int range = (i + 1) + ((n - 1) - 2 * i);    //범위

            for(int j = i; j < range; j++)
                map[j][i] = value--;

            for(int j = i + 1; j < range; j++)
                map[range - 1][j] = value--;

            for(int j = range - 2; j >= i; j--)
                map[j][range - 1] = value--;

            for(int j = range - 2; j >= i + 1; j--)
                map[i][j] = value--;
        }
    }

    static void printStat(int target) {
        StringBuilder sb = new StringBuilder();
        int n = map.length;
        int[] pos = new int[2];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] == target) {
                    pos[0] = i + 1;
                    pos[1] = j + 1;
                }
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }
        sb.append(pos[0] + " " + pos[1]);
        System.out.println(sb.toString());
    }
}