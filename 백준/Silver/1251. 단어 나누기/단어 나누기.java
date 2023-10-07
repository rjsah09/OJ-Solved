import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String fastest;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        fastest = "z".repeat(word.length());

        for (int i = 1; i < word.length() - 1; i++) {
            for (int j = i + 1; j < word.length(); j++) {
                getFastestWord(word, i, j);
            }
        }

        System.out.println(fastest);
    }

    static void getFastestWord(String word, int idx1, int idx2) {

        String[] tokenized = {word.substring(0, idx1), word.substring(idx1, idx2), word.substring(idx2)};
        for (int i = 0; i < 3; i++) {
            StringBuffer sb = new StringBuffer(tokenized[i]);
            tokenized[i] = sb.reverse().toString();
        }

        String str = "";
        for (int i = 0; i < 3; i++) {
            str += tokenized[i];
        }

        if (fastest.compareTo(str) > 0) {
            fastest = str;
        }
    }
}