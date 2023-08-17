import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            Map<String, Integer> categoryMap = new HashMap<>();

            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String category = st.nextToken();
                categoryMap.put(category, categoryMap.getOrDefault(category, 0) + 1);
            }

            int combinationCount = 1;
            for (int count : categoryMap.values()) {
                combinationCount *= count + 1;  //입지 않는 경우를 포함
            }

            sb.append(combinationCount - 1).append("\n");   //아무것도 선택하지 않는 경우를 제외
        }

        System.out.println(sb);
    }
}
