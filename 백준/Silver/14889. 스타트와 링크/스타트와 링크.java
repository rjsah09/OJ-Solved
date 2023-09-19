import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] abilities;
    static boolean[] areLeft;

    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        abilities = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                abilities[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result = Integer.MAX_VALUE;
        areLeft = new boolean[N];
        dfs(1, 0, true);
        dfs(0, 0, false);

        System.out.println(result);
    }

    static void dfs(int leftPlayerCount, int playerNumber, boolean belongLeft) {
        if (belongLeft) {
            areLeft[playerNumber] = true;
        }

        if (leftPlayerCount == N / 2) {
            int leftAbility = getScore(true);
            int rightAbility = getScore(false);
            result = Math.min(result, Math.abs(leftAbility - rightAbility));
            areLeft[playerNumber] = false;
            return;
        }

        if (playerNumber == N - 1) {
            areLeft[playerNumber] = false;
            return;
        }

        if (leftPlayerCount < N / 2) {
            dfs(leftPlayerCount + 1, playerNumber + 1, true);
        }

        dfs(leftPlayerCount, playerNumber + 1, false);

        areLeft[playerNumber] = false;
    }

    static int getScore(boolean isLeft) {
        int totalAbility = 0;
        for (int i = 0; i < N; i++) {
            if (areLeft[i] == isLeft) {
                for (int j = 0; j < N; j++) {
                    if (areLeft[i] == areLeft[j]) {
                        totalAbility += abilities[i][j];
                    }
                }
            }
        }

        return totalAbility;
    }

}
