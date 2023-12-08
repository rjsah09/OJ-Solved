import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int dice1 = Integer.parseInt(st.nextToken());
        int dice2 = Integer.parseInt(st.nextToken());
        int dice3 = Integer.parseInt(st.nextToken());

        int price = 0;
        if (dice1 == dice2 && dice2 == dice3) {
            price += 10000 + dice1 * 1000;
        } else if (dice1 == dice2) {
            price += 1000 + dice1 * 100;
        } else if (dice2 == dice3) {
            price += 1000 + dice2 * 100;
        } else if (dice3 == dice1) {
            price += 1000 + dice3 * 100;
        } else {
            int max = Math.max(dice1, Math.max(dice2, dice3));
            price += max * 100;
        }

        System.out.println(price);
    }
}
