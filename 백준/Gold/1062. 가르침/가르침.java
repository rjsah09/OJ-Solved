import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K;
    static String[] words;
    static boolean[] visited;

    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[26];

        if (K < 5) {
            System.out.println(0);
            return;
        }

        result = 0;
        words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        visited[0] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['c' - 'a'] = true;

        if (K == 5) {
            System.out.println(getKnowingWordCount());
            return;
        } else if (K == 26) {
            System.out.println(words.length);
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, 6);
                visited[i] = false;
            }
        }
        
        System.out.println(result);
    }

    static void dfs(int node, int letterCount) {
        if (letterCount == K) {
            int knowingWordsCount = getKnowingWordCount();
            result = Math.max(result, knowingWordsCount);
            return;
        }

        for (int i = node; i < 26; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, letterCount + 1);
                visited[i] = false;
            }
        }

    }

    static int getKnowingWordCount() {
        int count = words.length;
        for (int i = 0; i < words.length; i++) {  //단어
            int knowingLetterCount = 0;

            for (int j = 0; j < words[i].length(); j++) {   //단어의 한 글자
                int index = words[i].charAt(j) - 'a';
                if (!visited[index]) {
                    count--;
                    break;
                }
            }
        }

        return count;
    }
}