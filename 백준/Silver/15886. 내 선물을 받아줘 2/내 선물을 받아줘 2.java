import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String line = br.readLine();

        char[] board = new char[N];
        for (int i = 0; i < N; i++) {
            board[i] = line.charAt(i);
        }

        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                if (!visited[getNextPos(i, board)]) {
                    answer++;
                }
                travel(i, visited, board);
            }
        }

        System.out.println(answer);
    }

    static void travel(int pos, boolean[] visited, char[] board) {
        if (visited[pos]) {
            return;
        }

        visited[pos] = true;
        travel(getNextPos(pos, board), visited, board);
    }

    static int getNextPos(int pos, char[] board) {
        if (board[pos] == 'E') {
            return pos + 1;
        }

        return pos - 1;
    }
}
