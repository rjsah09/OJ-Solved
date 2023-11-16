import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int money = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
        int price = Integer.parseInt(br.readLine()) * 2;

        if (money >= price) {
            money -= price;
        }

        System.out.println(money);
    }
}
