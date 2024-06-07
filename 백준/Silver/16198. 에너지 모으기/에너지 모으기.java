import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//10:06 ~

public class Main {

    static int N;
    static int[] energies;
    static boolean[] visited;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        energies = new int[N];
        visited = new boolean[N];
        max = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i <  N; i++) {
            energies[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N - 1; i++) {
            visited[i] = true;
            dfs(i, 1, 0);
            visited[i] = false;
        }

        System.out.println(max);
    }

    static void dfs(int index, int depth, int gained) {
        int tempGain = 0;
        //index - 1의 에너지 모으기
        for (int i = index; i >= 0; i--) {
            if (!visited[i]) {
                tempGain += energies[i];
                break;
            }
        }

        //index + 1의 에너지 모으기
        for (int i = index; i < N; i++) {
            if (!visited[i]) {
                tempGain *= energies[i];
                break;
            }
        }

        gained += tempGain;

        if (depth == N - 2) {
            max = Math.max(max, gained);
            return;
        }

        for (int i = 1; i < N - 1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, depth + 1, gained);
                visited[i] = false;
            }
        }
    }
}
