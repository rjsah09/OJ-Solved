import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static int[] weights;
    static boolean[] visited;
    static boolean[] isNotPrime;
    static Set<Integer> primeSet;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        weights = new int[N];
        visited = new boolean[N];
        isNotPrime = new boolean[9001];
        primeSet = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        fillPrimeBoard();

        for (int i = 0; i < weights.length; i++) {
            dfs(i, 0, weights[i]);
        }

        if (primeSet.isEmpty()) {
            System.out.println(-1);
            return;
        }
        
        List<Integer> primeList = new ArrayList<>(primeSet);

        Collections.sort(primeList);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < primeList.size(); i++) {
            sb.append(primeList.get(i) + " ");
        }

        System.out.println(sb);
    }

    static void fillPrimeBoard() {
        isNotPrime[0] = isNotPrime[1] = true;

        for (int i = 2; i < isNotPrime.length; i++) {
            if (isNotPrime[i]) {
                continue;
            }

            for (int j = 2; i * j < isNotPrime.length; j++) {
                isNotPrime[i * j] = true;
            }
        }
    }

    static void dfs(int index, int depth, int sum) {
        visited[index] = true;

        if (depth == M -1) {
            if (!isNotPrime[sum]) {
                primeSet.add(sum);
            }

            visited[index] = false;
            return;
        }

        for (int i = index; i < weights.length; i++) {
            if (!visited[i]) {
                dfs(i, depth + 1, sum + weights[i]);
            }
        }

        visited[index] = false;
    }
}