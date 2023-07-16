import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        StringBuilder sb = new StringBuilder();
        while (!line.equals("END")) {
            StringBuffer buffer = new StringBuffer(line);
            sb.append(buffer.reverse() + "\n");
            line = br.readLine();
        }

        System.out.println(sb);
    }
}