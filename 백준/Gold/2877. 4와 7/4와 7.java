import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine()) - 1;

        int length = 1;
        int maxValue = (int)Math.pow(2, length);
        while (K - maxValue >= 0) {
            K -= maxValue;
            length++;
            maxValue = (int)Math.pow(2, length);
        }

        String left = Integer.toBinaryString(K);
        int front4Count = length - left.length();

        String result = "4".repeat(front4Count);
        for (int i = 0; i < left.length(); i++) {
            if (left.charAt(i) == '0') {
                result += "4";
            } else {
                result += "7";
            }
        }
        System.out.println(result);
    }

}
