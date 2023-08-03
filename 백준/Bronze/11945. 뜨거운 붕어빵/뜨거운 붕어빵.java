import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < height; i++) {
            StringBuffer stringBuffer = new StringBuffer(br.readLine()).reverse();
            sb.append(stringBuffer + "\n");
        }

        System.out.println(sb);
    }
}