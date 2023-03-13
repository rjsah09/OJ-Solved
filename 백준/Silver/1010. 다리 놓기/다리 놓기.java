import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dpSet = new int[30][30]; //0 ~ 29

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int n = Integer.parseInt(input);

        for(int i = 0; i < n; i++) {
            input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            int n2 = Integer.parseInt(st.nextToken());
            int n1 = Integer.parseInt(st.nextToken());

            System.out.println(dp(n1, n2));
        }
    }

    static int dp(int n, int r) {
        if(dpSet[n][r] > 0)
            return dpSet[n][r];

        if(n == 0 || r == 0 || n == r)
            return dpSet[n][r] = 1;

        if(n == 1)
            return dpSet[n][r] = r;

        return dpSet[n][r] =  dp(n - 1, r - 1) + dp(n - 1, r);
    }
}
