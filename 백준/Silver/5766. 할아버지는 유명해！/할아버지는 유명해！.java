import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        while (!line.equals("0 0")) {
            StringTokenizer st = new StringTokenizer(line);
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    int player = Integer.parseInt(st.nextToken());
                    map.put(player, map.getOrDefault(player, 0) + 1);
                }
            }

            List<Integer> valueList = new ArrayList<>(new HashSet<>(map.values()));
            Collections.sort(valueList, Collections.reverseOrder());
            int second = 0;
            if (valueList.size() > 1) {
                second = valueList.get(1);
            }

            String answer = "";
            ArrayList<Integer> players = new ArrayList<>(map.keySet());
            Collections.sort(players);
            for (int i = 0; i < players.size(); i++) {
                if (map.get(players.get(i)) == second) {
                    answer += players.get(i) + " ";
                }
            }

            System.out.println(answer);
            line = br.readLine();
        }
    }
}