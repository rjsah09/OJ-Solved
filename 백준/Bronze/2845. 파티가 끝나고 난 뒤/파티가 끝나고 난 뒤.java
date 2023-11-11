import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int participants = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            int criteria = Integer.parseInt(st.nextToken());
            sb.append(criteria - participants).append(" ");
        }

        System.out.println(sb);
    }
}