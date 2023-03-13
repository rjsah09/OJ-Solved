import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] num;
    static int[] operator;
    static int max = -1000000000, min = 1000000000;

    public static void main(String[] args) throws IOException {
        init();

        for(int i = 0; i < 4; i++) {
            if(operator[i] > 0)
                dfs(num[0], i, 1);
        }

        System.out.println(max);
        System.out.println(min);
    }

    static void init() throws IOException {
        operator = new int[4];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        n = Integer.parseInt(input);
        num = new int[n];

        input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        for(int i = 0; i < n; i++)
            num[i] = Integer.parseInt(st.nextToken());

        input = br.readLine();
        st = new StringTokenizer(input);
        for (int i = 0; i < 4; i++)
            operator[i] = Integer.parseInt(st.nextToken());
    }

    static void dfs(int sum, int oper, int depth) {
        sum = calc(sum, oper, depth);
        operator[oper]--;

        if(depth == n - 1) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            operator[oper]++;
            return;
        }

        for(int i = 0; i < 4; i++) {
            if(operator[i] > 0)
                dfs(sum, i, depth + 1);
        }

        operator[oper]++;
    }

    static int calc(int sum, int oper, int depth) {
        switch(oper) {
            case 0:
                sum += num[depth];
                break;
            case 1:
                sum -= num[depth];
                break;
            case 2:
                sum *= num[depth];
                break;
            case 3:
                if(sum < 0 && num[depth] > 0)
                    sum = -1 * (Math.abs(sum) / num[depth]);
                else
                    sum /= num[depth];
                break;
        }
        return sum;
    }

}
