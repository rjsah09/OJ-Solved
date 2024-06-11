import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//10:18

public class Main {

    static int N;   //사람의 수
    static int[] loss;
    static int[] gains;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        loss = new int[N];
        gains = new int[N];
        max = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            loss[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            gains[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int health = 100 - loss[i];
            if (health > 0) {
                dfs(i, health, gains[i]);
            }
        }

        System.out.println(max);
    }

    static void dfs(int index, int health, int happiness) {
        max = Math.max(max, happiness);

        for (int i = index + 1; i < N; i++) {
            int newHealth = health - loss[i];
            if (newHealth > 0) {
                dfs(i, newHealth, happiness + gains[i]);
            }
        }
    }
}
