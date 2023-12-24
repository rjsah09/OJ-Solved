import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String password = br.readLine();
            String result = "no";
            if (password.length() >= 6 && password.length() <= 9) {
                result = "yes";
            }

            System.out.println(result);
        }
    }
}