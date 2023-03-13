import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] win = new int[n]; //1은 상근, 2는 창영

        win[0] = 1;
        
        if(n >= 2)
            win[1] = 2;

        if(n >= 3) {
            for (int i = 2; i < n; i++) {
                win[i] = win[i - 2];
            }
        }

        if(win[n - 1] == 1)
            System.out.println("SK");
        else
            System.out.println("CY");
    }
}
