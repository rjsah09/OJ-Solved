import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static String[][] map;
    static String[][] status;
    static String[][] answer;
    static boolean trapped = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new String[n][n];
        status = new String[n][n];
        answer = new String[n][n];

        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j < n; j++)
                map[i][j] = line.substring(j, j + 1);
        }

        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j < n; j++) {
                status[i][j] = line.substring(j, j + 1);
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(status[i][j].equals("x"))
                    detection(i, j);
                else answer[i][j] = ".";
            }
        }

        if(trapped) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(map[i][j].equals("*")) answer[i][j] = "*";
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++)
                System.out.print(answer[i][j]);
            System.out.println();
        }
    }

    static void detection(int posI, int posJ) {
        int detected = 0;

        if(map[posI][posJ].equals("*")) {
            trapped = true;
            return;
        }

        for(int i = -1; i < 2; i++) {
            for(int j = -1; j < 2; j++) {
                if(i == 0 && j == 0) continue;
                int newPosI = posI + i;
                int newPosJ = posJ + j;
                if(isPosSafe(newPosI, newPosJ)) {
                    if (map[newPosI][newPosJ].equals("*"))
                        detected++;
                }
            }
        }

        answer[posI][posJ] = Integer.toString(detected);
    }

    static boolean isPosSafe(int posI, int posJ) {
        if(posI < 0 || posI >= n || posJ < 0 || posJ >= n)
            return false;
        return true;
    }
}