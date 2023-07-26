import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        String name = st.nextToken();
        int age = Integer.parseInt(st.nextToken());
        int weight = Integer.parseInt(st.nextToken());
        while (!name.equals("#")) {
            sb.append(name + " ");
            if (age > 17 || weight >= 80) {
                sb.append("Senior" + "\n");
            } else {
                sb.append("Junior" + "\n");
            }

            st = new StringTokenizer(br.readLine());
            name = st.nextToken();
            age = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());
        }

        System.out.println(sb);
    }
}
