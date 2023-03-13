import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input, "<>", true);
        StringBuilder sb = new StringBuilder();

        while(st.hasMoreTokens()) {
            String str = st.nextToken();
            if(str.equals("<"))
                sb.append(str + st.nextToken() + st.nextToken()); // < + 문자열 + >
            else
                sb.append(reverseWord(str));
        }

        System.out.println(sb);
    }

    static String reverseWord(String str) {
        StringTokenizer st = new StringTokenizer(str, " ", true);
        StringBuilder sb = new StringBuilder();

        while(st.hasMoreTokens()) {
            String token = st.nextToken();
            for(int i = token.length() - 1; i >= 0; i--) {
                sb.append(token.substring(i, i + 1));
            }
        }

        return sb.toString();
    }
}