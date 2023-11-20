import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());

        if (S == 1) {
            System.out.println(1);
            return;
        }
        
        long sum = 0L;
        for (long i = 1L; i <= S; i++) {
            if (sum + i > S) {
                System.out.println(i - 1);
                return;
            } else {
                sum += i;
            }
        }
    }
}
