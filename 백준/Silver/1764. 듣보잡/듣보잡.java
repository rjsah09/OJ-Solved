import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int notSeenCount = Integer.parseInt(st.nextToken());
        int notHeardCount = Integer.parseInt(st.nextToken());

        Map<String, Integer> notSeenOrHeardMap = new HashMap<>();
        for (int i = 0; i < notHeardCount + notSeenCount; i++) {
            String name = br.readLine();
            notSeenOrHeardMap.put(name, notSeenOrHeardMap.getOrDefault(name, 0) + 1);
        }

        Iterator<String> iter = notSeenOrHeardMap.keySet().iterator();
        ArrayList<String> notSeenAndHeardList = new ArrayList<>();
        while (iter.hasNext()) {
            String name = iter.next();
            if (notSeenOrHeardMap.get(name) == 2) {
                notSeenAndHeardList.add(name);
            }
        }

        Collections.sort(notSeenAndHeardList);

        StringBuilder sb = new StringBuilder();
        for (String name: notSeenAndHeardList) {
            sb.append(name).append("\n");
        }

        System.out.println(notSeenAndHeardList.size());
        System.out.println(sb);
    }
}
