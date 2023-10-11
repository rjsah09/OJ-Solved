import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String line = br.readLine();
            if (line == null || line.isEmpty()) {
                System.out.println(sb);
                return;
            }

            StringTokenizer st = new StringTokenizer(line);
            String s = st.nextToken();
            String t = st.nextToken();

            String result = isSubsequence(s, t) ? "Yes" : "No";
            sb.append(result + "\n");
        }
    }

    static boolean isSubsequence(String s, String t) {
        int startPoint = 0;
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);

            startPoint = t.indexOf(letter);
            if (startPoint == -1) {
                return false;
            }

            t = t.substring(startPoint + 1);
        }

        return true;
    }
}
