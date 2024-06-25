import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//09:50 ~ 09:55
//10:45 ~ 52
//11:40 ~ 12:00
//13:38 ~ 14:00
//14:09 ~ 14:19
//17:53 ~

public class Main {

    static int N;
    static int[] board;
    static boolean[] visited;
    static List<Integer> included;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N + 1];
        visited = new boolean[N + 1];
        included = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            board[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            dfs (i, i);
            visited[i] = false;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(included.size()).append("\n");
        for (int index: included) {
            sb.append(index).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int rootIndex, int index) {
        int nextIndex = board[index];

        if (!visited[nextIndex]) {
            visited[nextIndex] = true;
            dfs(rootIndex, nextIndex);
            visited[nextIndex] = false;
        }

        //순환 관계라면
        if (nextIndex == rootIndex) {
            //루트 노드를 더한다
            included.add(rootIndex);
        }
    }
}
