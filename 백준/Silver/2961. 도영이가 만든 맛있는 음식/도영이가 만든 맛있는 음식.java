import java.util.Scanner;

public class Main {
    static int n;
    static int[][] taste;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        taste = new int[n][2];
        visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            taste[i][0] = in.nextInt();
            taste[i][1] = in.nextInt();
        }

        dfs(0);

        System.out.println(answer);
    }

    static void dfs(int depth) {
        if(n == 1) {
            answer = Math.abs(taste[0][0] - taste[0][1]);
            return;
        }

        if(depth == n) {
            for(int i = 0; i < n; i++) {
                if(visited[i]) {
                    int totalSour = 1;
                    int totalBitter = 0;
                    for(int j = 0; j < n; j++) {
                        if(visited[j]) {
                            totalSour *= taste[j][0];
                            totalBitter += taste[j][1];
                        }
                    }
                    int difference = Math.abs(totalSour - totalBitter);
                    answer = Math.min(answer, difference);
                    return;
                }
            }
            return;
        }

        visited[depth] = true;
        dfs(depth + 1);
        visited[depth] = false;
        dfs(depth + 1);
    }
}
