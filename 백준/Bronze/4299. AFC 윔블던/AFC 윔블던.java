import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = Integer.parseInt(st.nextToken());
        int diff = Integer.parseInt(st.nextToken());

        if (sum < diff) {
            System.out.println(-1);
            return;
        }

        if ((sum + diff) % 2 != 0) {
            System.out.println(-1);
            return;
        }

        int team1 = (sum + diff) / 2;
        int team2 = Math.abs((sum - diff)/ 2);

        String answer = team1 > team2 ? team1 + " " + team2 : team2 + " " + team1;
        System.out.println(answer);
    }
}
