import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Map<Character, Integer> letterMap;
    static List<String> anagramList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            letterMap = new HashMap<>();
            for (int j = 0; j < word.length(); j++) {
                char key = word.charAt(j);
                letterMap.put(key, letterMap.getOrDefault(key, 0) + 1);
            }

            anagramList = new ArrayList<>();
            for (char letter : letterMap.keySet()) {
                dfs(word.length(), letter, "");
            }
            Collections.sort(anagramList);

            for (String anagram : anagramList) {
                sb.append(anagram).append("\n");
            }
        }

        System.out.println(sb);
    }

    static void dfs(int maxDepth, char letter, String word){
        word += letter;
        letterMap.put(letter, letterMap.get(letter) - 1);

        if (word.length() == maxDepth) {
            letterMap.put(letter, letterMap.get(letter) + 1);
            anagramList.add(word);
            return;
        }

        for (char nextLetter : letterMap.keySet()) {
            if (letterMap.get(nextLetter) > 0) {
                dfs(maxDepth, nextLetter, word);
            }
        }

        letterMap.put(letter, letterMap.get(letter) + 1);
    }
}