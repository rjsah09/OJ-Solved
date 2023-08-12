import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> vowelSet = new HashSet<>(Arrays.asList("a", "e", "i", "o", "u", "A", "E", "I", "O", "U"));

        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        while (!line.equals("#")) {
            int count = 0;
            for (int i = 0; i < line.length(); i++) {
                if (vowelSet.contains(line.substring(i, i + 1))) {
                    count++;
                }
            }
            sb.append(count).append("\n");

            line = br.readLine();
        }


        System.out.println(sb);
    }
}
