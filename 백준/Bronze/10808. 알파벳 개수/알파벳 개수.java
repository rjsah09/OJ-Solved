import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        int[] letterCounts = new int[26];
        for (int i = 0; i < word.length(); i++) {
            int letterIndex = word.charAt(i) - 'a';
            letterCounts[letterIndex]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int letterCount: letterCounts) {
            sb.append(letterCount + " ");
        }

        System.out.println(sb);
    }
}
