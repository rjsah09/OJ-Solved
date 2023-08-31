import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int month = Integer.parseInt(br.readLine());
        int day = Integer.parseInt(br.readLine());

        String result = "Before";
        if (month == 2) {
            if (day == 18) {
                result = "Special";
            } else if (day > 18) {
                result = "After";
            }
        } else if (month > 2) {
            result = "After";
        }

        System.out.println(result);
    }
}