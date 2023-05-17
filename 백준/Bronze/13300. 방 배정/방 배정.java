import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int total = Integer.parseInt(st.nextToken());
        int capacity = Integer.parseInt(st.nextToken());

        int[][] count = new int[6][2];  //[학년][성별]
        for(int i = 0; i < total; i++) {
            line = br.readLine();
            st = new StringTokenizer(line);
            int sex = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());
            count[grade - 1][sex]++;
        }

        int answer = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 2; j++) {
                answer += count[i][j] / capacity;
                if (count[i][j] % capacity > 0) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}