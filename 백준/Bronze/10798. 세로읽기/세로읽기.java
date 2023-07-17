import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] words = new String[5];
        for (int i = 0; i < words.length; i++) {
            words[i] = br.readLine();
        }

        StringBuilder sb = new StringBuilder();
        while (!usedAllLetters(words)) {
            for (int i = 0; i < 5; i++) {
                if (words[i].length() != 0) {
                    sb.append(words[i].substring(0, 1));
                    words[i] = words[i].substring(1);
                }
            }
        }

        System.out.println(sb);
    }

    static boolean usedAllLetters(String[] words) {
        for (int i = 0; i < 5; i++) {
            if (words[i].length() != 0) {
                return false;
            }
        }

        return true;
    }
}