import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static int N;
    static String[] words;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        for (int i = 0; i < N; i++) {   //비교할 기준점
            String standard = words[i];
            for (int j = i + 1; j < N; j++) {   //비교 대상
                if (isSamePattern(standard, words[j])) {
                    result++;
                }
            }
        }

        System.out.println(result);

    }

    static boolean isSamePattern(String str1, String str2) {
        Map<Character, Integer> str1Map = new HashMap<>();
        Map<Character, Integer> str2Map = new HashMap<>();

        int index1 = 0;
        for (int i = 0; i < str1.length(); i++) {
            char key = str1.charAt(i);
            if (str1Map.containsKey(key)) {
                continue;
            }

            str1Map.put(key, index1);
            index1++;
        }

        String pattern1 = "";
        for (int i = 0; i < str1.length(); i++) {
            pattern1 += str1Map.get(str1.charAt(i)) + " ";
        }

        int index2 = 0;
        for (int i = 0; i < str2.length(); i++) {
            char key = str2.charAt(i);
            if (str2Map.containsKey(key)) {
                continue;
            }

            str2Map.put(key, index2);
            index2++;
        }

        String pattern2 = "";
        for (int i = 0; i < str2.length(); i++) {
            pattern2 += str2Map.get(str2.charAt(i)) + " ";
        }


        return pattern1.equals(pattern2);
    }


}
