import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] numbers = new int[N];
        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(numbers);
        StringBuilder sb = new StringBuilder();
        for (int number: numbers) {
            sb.append(number + "\n");
        }

        System.out.println(sb);
    }
}