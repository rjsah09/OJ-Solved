import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        String[][] map = new String[R][C];  //맵
        String[][] resultMap = new String[R][C];    //결과맵

        // 입력 받기
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                String now = String.valueOf(line.charAt(j));
                map[i][j] = now;
                resultMap[i][j] = now;
            }
        }

        // 50년 후의 지도 만들기
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {

                if (map[i][j].equals("X")) {
                    int seaCount = 0;
                    
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny].equals(".")) {
                            seaCount++;
                        } else if (nx < 0 || nx >= R || ny < 0 || ny >= C) {    /** 오류 */
                            seaCount++;
                        }
                    }
                    
                    if (seaCount >= 3) {
                        resultMap[i][j] = ".";
                    }
                }
            }
        }

        // 결과 출력
        int startX = R, startY = C, endX = 0, endY = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (resultMap[i][j].equals("X")) {
                    startX = Math.min(startX, i);
                    startY = Math.min(startY, j);
                    endX = Math.max(endX, i);
                    endY = Math.max(endY, j);
                }
            }
        }
        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                System.out.print(resultMap[i][j]);
            }
            System.out.println();
        }
    }
}
