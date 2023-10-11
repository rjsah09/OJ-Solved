import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

public class Main {

    static Set<Character> vowelSet;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        vowelSet = Set.of('a', 'e', 'i', 'o', 'u');

        StringBuilder sb = new StringBuilder();
        String password = br.readLine();
        while (!password.equals("end")) {
            sb.append("<" + password + "> ");
            if (isPasswordAcceptable(password)) {
                sb.append("is acceptable.\n");
            } else {
                sb.append("is not acceptable.\n");
            }
            password = br.readLine();
        }

        System.out.println(sb);
    }

    static boolean isPasswordAcceptable(String password) {
        return (vowelIncluded(password) && !isContinuousThreeVowels(password) && !haveTwoSameLetter(password));
    }

    static boolean vowelIncluded(String password) {
        for (int i = 0; i < password.length(); i++) {
            char letter = password.charAt(i);
            if (vowelSet.contains(letter)) {
                return true;
            }
        }

        return false;
    }

    static boolean isContinuousThreeVowels(String password) {
        for (int i = 0; i < password.length() - 2; i++) {
            int vowelCount = 0;
            int consonantCount = 0;

            for (int j = i; j < i + 3; j++) {
                char letter = password.charAt(j);
                if (vowelSet.contains(letter)) {
                    vowelCount++;
                } else {
                    consonantCount++;
                }
            }

            if (vowelCount == 3 || consonantCount == 3) {
                return true;
            }
        }

        return false;
    }

    static boolean haveTwoSameLetter(String password) {
        for (int i = 0; i < password.length() - 1; i++) {
            char pre = password.charAt(i);
            char post = password.charAt(i + 1);
            if (pre == post) {
                if (pre == 'e' || pre == 'o') {
                    continue;
                }
                return true;
            }
        }

        return false;
    }
}