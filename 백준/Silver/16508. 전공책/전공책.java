import java.util.Scanner;

public class Main {
    static String target;
    static int n;
    static int[] price; //가격
    static String[] book;   //책
    static boolean[] visited;   //노드 방문
    static int answer = -1;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        target = in.next();
        n = in.nextInt();
        price = new int[n];
        book = new String[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            price[i] = in.nextInt();
            book[i] = in.next();
        }

        String totalStr = "";
        int totalPr = 0;
        for(int i = 0; i < n; i++) {
            totalStr += book[i];
            totalPr += price[i];
        }
        if(isPass(totalStr)) answer = totalPr;

        for (int i = 0; i < n; i++) {
            dfs(0, i, "", 0);
        }

        System.out.println(answer);
    }

    static void dfs(int depth, int node, String prevStr, int prevPr) {
        visited[node] = true;
        prevStr += book[node];
        prevPr += price[node];

        if(prevPr > answer) {
            visited[node] = false;
            return;
        }

        if(isPass(prevStr)) {
            if(answer == -1 || answer > prevPr) {
                answer = prevPr;
                visited[node] = false;
                return;
            }
        }

        if(depth < n - 1) {
            for(int i = 0; i < n; i++)
                if(!visited[i]) dfs(depth + 1, i, prevStr, prevPr);
        }

        visited[node] = false;
    }

    static boolean isPass(String givenStr) {
        for(int i = 0; i < target.length(); i++) {
            int idx = givenStr.indexOf(target.substring(i, i + 1));
            if(idx == -1)
                return false;
            else {
                givenStr = givenStr.substring(0, idx) + givenStr.substring(idx + 1, givenStr.length());
            }
        }
        return true;
    }
}
