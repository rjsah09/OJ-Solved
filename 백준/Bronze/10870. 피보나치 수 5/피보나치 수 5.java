import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] fibo = new int[n + 1];
        fibo[0] = 0;

        if(n > 0) {
            if(n >= 1) fibo[1] = 1;
            if(n >= 2) fibo[2] = 1;
            if(n >= 3)
            for (int i = 3; i <= n; i++)
                fibo[i] = fibo[i - 1] + fibo[i - 2];
        }

        System.out.println(fibo[n]);
    }
}