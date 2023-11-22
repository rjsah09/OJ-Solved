import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "/");
        int kill = Integer.parseInt(st.nextToken());
        int death = Integer.parseInt(st.nextToken());
        int assist = Integer.parseInt(st.nextToken());

        String result = "gosu";
        if (kill + assist < death || death == 0) {
            result = "hasu";
        }

        System.out.println(result);
    }
}