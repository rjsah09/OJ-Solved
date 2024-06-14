import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//08:47 ~ 09:01
//09:52 ~ 10:01
//13:46 ~ 14:00
//24:50 ~


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int aCount = 0;

        for (int i = 0;  i < input.length(); i++) {
            if (input.charAt(i) == 'a') {
                aCount++;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i  = 0; i < input.length(); i++) {
            int bCount = 0;

            for (int j = 0; j < aCount; j++) {
                if (input.charAt((i + j) % input.length()) == 'b') {
                    bCount++;
                }
            }

            min = Math.min(min, bCount);
        }

        System.out.println(min);
    }
}
