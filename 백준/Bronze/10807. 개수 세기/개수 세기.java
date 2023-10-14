import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Integer, Integer> countMap = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            countMap.put(number, countMap.getOrDefault(number, 0) + 1);
        }

        int target = Integer.parseInt(br.readLine());
        int result = 0;
        if (countMap.containsKey(target)) {
            result = countMap.get(target);
        }
        System.out.println(result);
    }
}