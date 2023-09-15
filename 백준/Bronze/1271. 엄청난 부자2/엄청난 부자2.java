import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger money = new BigInteger(st.nextToken());
        BigInteger peopleCount = new BigInteger(st.nextToken());

        BigInteger moneyPerPerson = money.divide(peopleCount);
        BigInteger left = money.mod(peopleCount);

        System.out.println(moneyPerPerson);
        System.out.println(left);
    }
}