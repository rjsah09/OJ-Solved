import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N;
    static int count;
    static String result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        count = -1;
        result = "-1";

        bfs();

        System.out.println(result);
    }

    static void bfs() {
        Queue<String> q = new LinkedList<>();
        q.add("");

        while (!q.isEmpty()) {
            String now = q.poll();
            int last = now.isEmpty() ? 9 : Integer.parseInt(now.substring(now.length() - 1));

            for (int i = 0; i <= last; i++) {
                String next = now + i;
                if (isDecreasingNumber(next)) {
                    count++;
                    if (count == N) {
                        result = next;
                        return;
                    }

                    q.add(next);
                }
            }
        }
    }

    static boolean isDecreasingNumber(String str) {
        if (str.length() == 1) {
            return true;
        }

        int prev = Integer.parseInt(str.substring(str.length() - 2, str.length() - 1));
        int post = Integer.parseInt(str.substring(str.length() - 1));
        return prev > post;
    }
}
