import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map = new int[5][5];
    static boolean[][] check = new boolean[5][5];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;

        for(int i = 0; i < 5; i++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            for(int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < 5; i++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            for(int j = 0; j < 5; j++) {
                int call = Integer.parseInt(st.nextToken());
                marking(call);
                count++;
                if(isBingo()) {
                    System.out.println(count);
                    return;
                }
            }
        }
    }

    static void marking(int call) {
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(map[i][j] == call) {
                    check[i][j] = true;
                    return;
                }
            }
        }
    }

    static boolean isBingo(){
        int bingos = 0;

        //대각 빙고 체크
        for(int i = 0; i < 5; i++) {
            if(!check[i][i]) break;
            if(i == 4) bingos++;
        }

        for(int i = 0; i < 5; i++) {
            if(!check[4 - i][i]) break;
            if(i == 4) bingos++;
        }

        //가로선 체크
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(!check[i][j]) break;
                if(j == 4)  {
                    if(++bingos >= 3)
                        return true;
                }
            }
        }

        //세로선 체크
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(!check[j][i]) break;
                if(j == 4)  {
                    if(++bingos >= 3)
                        return true;
                }
            }
        }

        return false;
    }

}