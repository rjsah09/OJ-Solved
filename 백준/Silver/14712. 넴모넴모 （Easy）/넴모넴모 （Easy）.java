import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, m;
    static boolean[][] visited;
    static int[][] loc;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        visited = new boolean[n][m];

        dfs(0, 0, true);
        dfs(0, 0, false);

        System.out.println(ans);
    }

    static void dfs(int node, int cnt, boolean visit) {
        int posI = node / m;
        int posJ = node % m;

        visited[posI][posJ] = visit;

        if(posI > 0 && posJ > 0) {
            if (hasSquare(posI, posJ)) {
                visited[posI][posJ] = false;
                return;
            }
        }

        if(node == n * m - 1) {
            ans++;
        } else {
            dfs(node + 1, cnt, true);
            dfs(node + 1, cnt, false);
        }

        visited[posI][posJ] = false;
    }

    static boolean hasSquare(int posI, int posJ) {
        if (visited[posI][posJ] && visited[posI][posJ - 1] && visited[posI - 1][posJ] && visited[posI - 1][posJ - 1])
            return true;
        return false;
    }
}
