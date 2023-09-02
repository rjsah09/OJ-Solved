import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String X;
    static boolean[] visited;
    static char[] XValue;

    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        X = br.readLine();

        result = 0;
        visited = new boolean[X.length()];
        XValue = new char[X.length()];
        for (int i = 0; i < XValue.length; i++) {
            XValue[i] = X.charAt(i);
        }

        for (int i = 0; i < XValue.length; i++) {
            if (XValue[i] - 0 >= XValue[0] - 0) {
                visited[i] = true;
                dfs("", i);
                visited[i] = false;
            }
        }

        System.out.println(result);

    }

    public static void dfs(String prev, int index) {
        String now = prev + XValue[index];

        if (now.length() == X.length()) {
            int totalNum = Integer.parseInt(now);
            if (totalNum <= Integer.parseInt(X)) {
                return;
            }
            result = result == 0 ? Integer.parseInt(now) : Math.min(result, Integer.parseInt(now));
        }

        for (int i = 0; i < XValue.length; i++) {
            if (!visited[i] && Integer.parseInt(now + XValue[i]) >= Integer.parseInt(X.substring(0, prev.length() + 1))) {
                visited[i] = true;
                dfs (now, i);
                visited[i] = false;
            }
        }

    }
}
