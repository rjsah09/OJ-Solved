import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] egg; //[내구도, 무게]
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        n = Integer.parseInt(input);
        egg = new int[n][2];

        for(int i = 0; i < n; i++) {
            input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            egg[i][0] = Integer.parseInt(st.nextToken());
            egg[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < n; i++) {
            dfs(0, i);
        }

        System.out.println(answer);
    }

    static void dfs(int pick, int node) {
        boolean smashed = false;
        if(egg[pick][0] > 0 && egg[node][0] > 0) {
            smashed = true;
            egg[pick][0] -= egg[node][1];
            egg[node][0] -= egg[pick][1];
        }

        int broken = 0;
        for(int i = 0; i < n; i++) {
            if(egg[i][0] <= 0) broken++;
        }
        answer = Math.max(answer, broken);
        if(broken == n) {
            egg[pick][0] += egg[node][1];
            egg[node][0] += egg[pick][1];
            return;
        }

        for(int i = 0; i < n; i++) {
            if(pick + 1 == n) break;
            if (pick + 1 != i && egg[i][0] > 0) dfs(pick + 1, i);
        }

        if(smashed) {
            egg[pick][0] += egg[node][1];
            egg[node][0] += egg[pick][1];
        }
    }
}