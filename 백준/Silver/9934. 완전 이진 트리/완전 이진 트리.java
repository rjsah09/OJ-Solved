import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        String[] result = new String[K];
        for (int i = 0; i < result.length; i++) {
            result[i] = "";
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nodes = new int[st.countTokens()];

        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = Integer.parseInt(st.nextToken());
        }

        travel(nodes, K, result, 0, nodes.length, 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i] + "\n");
        }
        System.out.println(sb);

    }

    static void travel(int[] nodes, int K, String[] result, int start, int end, int depth) {
        if (depth < (K - 1)) {
            travel(nodes, K, result, start, (start + end) / 2, depth + 1);
        }
        result[depth] += nodes[(start + end) / 2] + " ";
        if (depth < (K - 1)) {
            travel(nodes, K, result, (start + end) / 2 + 1, end, depth + 1);
        }
    }
}
