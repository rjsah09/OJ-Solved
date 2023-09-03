import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] scores = new int[6];
        int minimum1 = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            scores[i] = Integer.parseInt(br.readLine());
            sum += scores[i];
            minimum1 = Math.min(scores[i], minimum1);
        }

        int minimum2 = Integer.MAX_VALUE;
        for (int i = 4; i < 6; i++) {
            scores[i] = Integer.parseInt(br.readLine());
            sum += scores[i];
            minimum2 = Math.min(scores[i], minimum2);
        }

        System.out.println(sum - minimum1 - minimum2);
    }
}
