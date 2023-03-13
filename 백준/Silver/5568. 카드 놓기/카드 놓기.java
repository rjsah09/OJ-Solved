import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static boolean[] visited;
    static String[] card;
    static ArrayList<String> maked = new ArrayList<>();
    static int picks;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cards = in.nextInt();
        picks = in.nextInt();
        visited = new boolean[cards];
        card = new String[cards];

        for(int i = 0; i < cards; i++) card[i] = in.next();

        for(int i = 0; i < cards; i++) {
            dfs(i, 0, "");
        }

        System.out.println(maked.size());
    }

    static void dfs(int node, int level, String str) {
        visited[node] = true;
        level++;
        str += card[node];

        if(level == picks) {
            if(!maked.contains(str)) maked.add(str);
        } if(level > picks) {
            visited[node] = false;
            return;
        }

        for(int i = 0; i < visited.length; i++) {
            if (!visited[i]) dfs(i, level, str);
        }
        visited[node] = false;
    }

}
