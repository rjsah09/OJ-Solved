import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = new int[9];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        int min = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > numbers[min]) {
                min = i;
            }
        }

        System.out.println(numbers[min]);
        System.out.println(min + 1);
    }
}
