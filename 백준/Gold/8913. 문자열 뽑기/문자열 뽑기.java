import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] answers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        answers = new int[N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            dfs(input, i);
        }

        for (int i = 0; i < N; i++) {
            System.out.println(answers[i]);
        }
    }

    static void dfs(String word, int n) {
        if (word.isEmpty()) {
            answers[n] = 1;
            return;
        }

        char lastLetter = 'c';

        for (int i = 0; i < word.length() - 1; i++) {
            if (word.charAt(i) == word.charAt(i + 1) && word.charAt(i) != lastLetter && answers[n] == 0) {
                String picked = pick(word, i);
                dfs(pick(word, i), n);
            }

            lastLetter = word.charAt(i);
        }
    }

    static String pick(String word, int index) {
        char letter = word.charAt(index);
        char findLetter = letter == 'a' ? 'b' : 'a';
        int endIndex = word.indexOf(findLetter, index);

        return (endIndex == -1) ? word.substring(0, index) : word.substring(0, index) + word.substring(endIndex);
    }

}
