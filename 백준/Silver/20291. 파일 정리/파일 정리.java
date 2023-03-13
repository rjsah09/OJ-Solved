import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int files = Integer.parseInt(br.readLine());
        String[] file = new String[files];
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < files; i++) {
            String input = br.readLine();
            String extension = input.substring(input.indexOf('.') + 1, input.length());
            map.put(extension, map.getOrDefault(extension, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        String[] sorted = map.keySet().toArray(new String[0]);
        Arrays.sort(sorted);
        for(String str: sorted) {
            sb.append(str + " " + map.get(str) + "\n");
        }
        System.out.println(sb);
    }
}