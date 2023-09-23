import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int QUESTION_COUNT = 10;
    static int[] answers;
    static int[] picks;

    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        answers = new int[QUESTION_COUNT];
        picks = new int[QUESTION_COUNT];

        for (int i = 0; i < QUESTION_COUNT; i++) {
            answers[i] = Integer.parseInt(st.nextToken());
        }

        result = 0;
        for (int i = 1; i <= 5; i++) {
            dfs(0, 0, i);
        }

        System.out.println(result);
    }

    static void dfs(int correctCount, int questionIndex, int pick) {
        picks[questionIndex] = pick;

        if (pick == answers[questionIndex]) {
            correctCount++;
        }

        if (questionIndex >= QUESTION_COUNT - 1) {
            if (correctCount >= 5) {
                result++;
            }
            return;
        }

        for (int i = 1; i <= 5; i++) {
            if (isNumberAvailable(questionIndex + 1, i)) {
                dfs(correctCount, questionIndex + 1, i);
            }
        }
    }

    static boolean isNumberAvailable(int question, int pick) {
        if (question < 2) {
            return true;
        }

        if (picks[question - 2] == picks[question - 1] && picks[question - 2] == pick) {
            return false;
        }

        return true;
    }
}