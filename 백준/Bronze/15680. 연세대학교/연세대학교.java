import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = "YONSEI";
        String slogan = "Leading the Way to the Future";
        int input = Integer.parseInt(br.readLine());
        String answer = input == 0 ? name : slogan;

        System.out.println(answer);
    }
}
