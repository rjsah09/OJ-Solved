import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        String binaryX = Integer.toBinaryString(X);

        for (int i = 0; i < binaryX.length(); i++) {
            if (binaryX.substring(i, i + 1).equals("1")) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}