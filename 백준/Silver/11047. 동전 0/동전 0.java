import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int coinCount = in.nextInt();
        int value = in.nextInt();
        Integer[] coins = new Integer[coinCount];
        int result = 0;

        for(int i = 0; i < coinCount; i++)
            coins[i] = in.nextInt();

        Arrays.sort(coins, Collections.reverseOrder());

        for(int i = 0; i < coinCount; i++) {
            result += value / coins[i];
            value = value % coins[i];
            if(value == 0)
                break;
        }

        System.out.println(result);
    }
}
