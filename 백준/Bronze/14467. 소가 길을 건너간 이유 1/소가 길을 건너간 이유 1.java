import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int crossing = Integer.parseInt(br.readLine());
        Map<Integer, Integer> cows = new HashMap<>();
        int crossed = 0;

        for(int i = 0; i < crossing; i++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int cowNum = Integer.parseInt(st.nextToken());
            int cowPos = Integer.parseInt(st.nextToken());

            if(cows.containsKey(cowNum)) {
                if(cows.get(cowNum) !=  cowPos) {
                    cows.put(cowNum, cowPos);
                    crossed++;
                }
            } else {
                cows.put(cowNum, cowPos);
            }
        }

        System.out.println(crossed);
    }
}
