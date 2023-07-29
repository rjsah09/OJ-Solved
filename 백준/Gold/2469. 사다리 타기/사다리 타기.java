import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());    //참가자 수
        int N = Integer.parseInt(br.readLine());    //사다리 높이

        String result = br.readLine();    //목표
        int[] resultsByIndex = new int[K];
        for (int i = 0; i < K; i++) {
            int participant = result.charAt(i) - 'A';
            resultsByIndex[participant] = i;
        }

        //사다리 생성
        String[] steps = new String[N];
        int hiddenStepIndex = 0;
        for (int i = 0; i < N; i++) {
            steps[i] = br.readLine();
            if (steps[i].contains("?")) {
                hiddenStepIndex = i;
            }
        }

        //사다리 탐색
        int[] uppedIndexes = new int[K];
        int[] downedIndexes = new int[K];
        for (int i = 0; i < K; i++) {
            //위에서 hiddenStepIndex 까지 탐색
            int downedIndex = i;
            for (int j = 0; j < hiddenStepIndex; j++) { //사다리 타기
                if (isIndexSafe(steps[j], downedIndex - 1) && steps[j].charAt(downedIndex - 1) == '-')  {
                    downedIndex--;
                } else if (isIndexSafe(steps[j], downedIndex) && steps[j].charAt(downedIndex) == '-') {
                    downedIndex++;
                }
            }

            //아래에서 hiddenStepIndex 까지 탐색
            int uppedIndex = resultsByIndex[i];
            for (int j = N - 1; j > hiddenStepIndex; j--) { //사다리 타기
                if (isIndexSafe(steps[j], uppedIndex - 1) && steps[j].charAt(uppedIndex - 1) == '-')  {
                    uppedIndex--;
                } else if (isIndexSafe(steps[j], uppedIndex) && steps[j].charAt(uppedIndex) == '-') {
                    uppedIndex++;
                }
            }

            uppedIndexes[uppedIndex] = i;
            downedIndexes[downedIndex] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K - 1; i++) {
            if (uppedIndexes[i] == downedIndexes[i]) {
                sb.append("*");
            } else if (uppedIndexes[i] == downedIndexes[i + 1] || uppedIndexes[i + 1] == downedIndexes[i]) {
                sb.append("-");
                int tmp = uppedIndexes[i];
                uppedIndexes[i] = uppedIndexes[i + 1];
                uppedIndexes[i + 1] = tmp;
            } else {
                System.out.println("x".repeat(K - 1));
                return;
            }
        }

        System.out.println(sb);
    }

    static boolean isIndexSafe(String str, int index) {
        if (index < 0 || index >= str.length()) {
            return false;
        }
        return true;
    }
}
