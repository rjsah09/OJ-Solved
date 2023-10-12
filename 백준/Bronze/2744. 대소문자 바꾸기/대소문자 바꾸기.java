import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            char letter = line.charAt(i);
            if (Character.isUpperCase(letter)) {
                result.append(Character.toLowerCase(letter));
            } else {
                result.append(Character.toUpperCase(letter));
            }
        }

        System.out.println(result);
    }
}
