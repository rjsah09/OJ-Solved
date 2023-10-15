import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int L, C;
    static char[] letters;
    static boolean[] visited;
    static List<String> passwordList;
    static Set<Character> vowelSet;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());   //비밀번호 길이
        C = Integer.parseInt(st.nextToken());   //사용 가능한 문자 종류
        letters = new char[C];
        visited = new boolean[C];
        passwordList = new ArrayList<>();
        vowelSet = Set.of('a', 'e', 'i', 'o', 'u');

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            letters[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(letters);

        for (int i = 0; i < C; i++) {
            visited[i] = true;

            dfs(i, "" + letters[i]);

            visited[i] = false;
        }

        Collections.sort(passwordList);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < passwordList.size(); i++) {
            sb.append(passwordList.get(i)).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int letterIndex, String word) {
        if (word.length() == L) {
            if (meetTheCriteria(word)) {
                passwordList.add(word);
            }

            return;
        }

        for (int i = letterIndex; i < C; i++) {
            if (!visited[i]) {
                visited[i] = true;

                dfs(i, word + letters[i]);

                visited[i] = false;
            }
        }
    }

    static boolean meetTheCriteria(String word) {
        int consonantCount = 0;
        int vowelCount = 0;

        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (vowelSet.contains(letter)) {
                vowelCount++;
            } else {
                consonantCount++;
            }
        }

        return vowelCount >= 1 && consonantCount >= 2;
    }

}