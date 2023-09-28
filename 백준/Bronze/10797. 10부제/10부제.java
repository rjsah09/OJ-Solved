import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int day = Integer.parseInt(br.readLine());
        int[] carNumbers = new int[5];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            carNumbers[i] = Integer.parseInt(st.nextToken());
        }

        int unableCount = 0;
        for (int carNumber : carNumbers) {
            if (carNumber == day) {
                unableCount++;
            }
        }

        System.out.println(unableCount);
    }
}
