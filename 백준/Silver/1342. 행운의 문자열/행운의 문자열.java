import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String input;
    static int[] letterCounts;
    static int luckyCount;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        letterCounts = new int[26];

        for (int i = 0; i < input.length(); i++) {
            int index = input.charAt(i) - 'a';
            letterCounts[index]++;
        }

        for (int i = 0; i < letterCounts.length; i++) {
            if (letterCounts[i] > 0) {
                letterCounts[i]--;
                dfs(i, String.valueOf((char)('a' + i)));
                letterCounts[i]++;
            }
        }

        System.out.println(luckyCount);
    }

    static void dfs(int index, String word) {
        if (word.length() == input.length()) {
            luckyCount++;
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (i != index && letterCounts[i] > 0) {
                letterCounts[i]--;
                dfs(i, word + (char)('a' + i));
                letterCounts[i]++;
            }
        }
    }
}
