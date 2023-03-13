import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int milks = in.nextInt();
        long totalPrice = 0;
        Integer[] prices = new Integer[milks];

        for (int i = 0; i < milks; i++)
            prices[i] =  in.nextInt();

        Arrays.sort(prices, Collections.reverseOrder());

        for (int i = 0; i < milks; i++) {
            if((i + 1) % 3 != 0)
                totalPrice += prices[i];
        }

        System.out.println(totalPrice);
    }
}