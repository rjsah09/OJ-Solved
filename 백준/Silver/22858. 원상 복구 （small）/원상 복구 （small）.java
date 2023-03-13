import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        int cards = Integer.parseInt(st.nextToken());
        int shuffled = Integer.parseInt(st.nextToken());

        int[] s = new int[cards];
        input = br.readLine();
        st = new StringTokenizer(input);
        for(int i = 0; i < cards; i++)
            s[i] = Integer.parseInt(st.nextToken());

        int[] d = new int[cards];
        input = br.readLine();
        st = new StringTokenizer(input);
        for(int i = 0; i < cards; i++)
            d[i] = Integer.parseInt(st.nextToken());


        for(int i = 0; i < shuffled; i++) {
            int[] tmp = new int[cards];
            for(int j = 0; j < cards; j++) {
                tmp[d[j] -1] = s[j];
            }
            s = tmp;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < cards; i++)
            sb.append(s[i] + " ");

        System.out.println(sb);
    }
}
