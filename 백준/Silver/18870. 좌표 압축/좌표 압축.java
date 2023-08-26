import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] coordinates = new int[N];
        int[] sorted = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            coordinates[i] = sorted[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sorted);

        Map<Integer, Integer> sortedMap = new HashMap<>();
        int lower = 0;
        for (int i = 0; i < sorted.length; i++) {
            if (!sortedMap.containsKey(sorted[i])) {
                sortedMap.put(sorted[i], lower++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < coordinates.length; i++) {
            sb.append(sortedMap.get(coordinates[i]) + " ");
        }

        System.out.println(sb);
    }
}
