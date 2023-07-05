import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int wordCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < wordCount; i++) {
            String word = br.readLine();

            if (isGroupWordChecker(word)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static boolean isGroupWordChecker(String word) {
        Set<Character> usedAlp = new HashSet<>();
        char prev = word.charAt(0);
        for (int i = 1; i < word.length(); i++) {
            char now = word.charAt(i);
            if (prev != now) {
                if (usedAlp.contains(now)) {
                    return false;
                }
                usedAlp.add(prev);
                prev = now;
            }
        }

        return true;
    }
}