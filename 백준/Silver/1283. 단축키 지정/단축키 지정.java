import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<String> hotkeySet = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            boolean hotkeyAble = false;

            StringTokenizer st = new StringTokenizer(command);
            String res = "";
            while (st.hasMoreTokens()) {
                String word = st.nextToken();
                if (hotkeySet.contains(word.substring(0, 1)) || hotkeyAble) {
                    res += word + " ";
                } else {
                    res += "[" + word.substring(0, 1) + "]" + word.substring(1) + " ";
                    hotkeyAble = true;
                    hotkeySet.add(word.substring(0, 1).toUpperCase());
                    hotkeySet.add(word.substring(0, 1).toLowerCase());
                }
            }

            if (hotkeyAble) {
                sb.append(res + "\n");
                continue;
            }

            for (int j = 1; j < command.length(); j++) {
                String letter = command.substring(j, j + 1);
                if (hotkeySet.contains(letter) || letter.equals(" ")) {
                    continue;
                }

                hotkeyAble = true;
                sb.append(command.substring(0, j) + "[" + letter + "]" + command.substring(j + 1) + "\n");
                hotkeySet.add(letter.toLowerCase());
                hotkeySet.add(letter.toUpperCase());
                break;
            }

            if (!hotkeyAble) {
                sb.append(res + "\n");
                continue;
            }
        }

        System.out.println(sb);
    }
}
