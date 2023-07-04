import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] size = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        int[] heights = new int[size[1]];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < heights.length; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= size[0]; i++) {
            boolean doCount = false;
            int count = 0;
            for (int j = 0; j < size[1]; j++) {
                if (heights[j] >= i) {
                    doCount = true;
                    answer += count;
                    count = 0;
                    continue;
                }

                if (doCount) {
                    count++;
                }
            }
        }

        System.out.println(answer);
    }
}
