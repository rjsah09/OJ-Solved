import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int minBurgerPrice = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            minBurgerPrice = Math.min(minBurgerPrice, Integer.parseInt(br.readLine()));
        }

        int minDrinkPrice = Integer.MAX_VALUE;
        for (int i = 0; i < 2; i++) {
            minDrinkPrice = Math.min(minDrinkPrice, Integer.parseInt(br.readLine()));
        }

        System.out.println(minBurgerPrice + minDrinkPrice - 50);
    }
}
