import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, String> intKeyDict = new HashMap<>();
        Map<String, Integer> StringKeyDict = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String pokemon = br.readLine();
            intKeyDict.put(i, pokemon);
            StringKeyDict.put(pokemon, i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String question = br.readLine();
            if (isNumber(question)) {
                sb.append(intKeyDict.get(Integer.parseInt(question))).append("\n");
            } else {
                sb.append(StringKeyDict.get(question)).append("\n");
            }
        }

        System.out.println(sb);
    }

    static boolean isNumber(String str) {
        for (int j = 0; j < str.length(); j++) {
            char ch = str.charAt(j);
            if (!Character.isDigit(ch)) {
                return false;
            }
        }

        return true;
    }
}
