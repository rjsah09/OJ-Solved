import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static int N;
    static List<String> amazingPrimeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int max = Integer.parseInt("9".repeat(N));
        amazingPrimeList = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            if (isPrime(i)) {
                dfs("" + i);
            }
        }

        Collections.sort(amazingPrimeList);

        StringBuilder sb = new StringBuilder();
        for (String prime : amazingPrimeList) {
            sb.append(prime).append("\n");
        }

        System.out.println(sb);
    }

    static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i <= (int)Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    static void dfs(String numberString) {
        if (numberString.length() == N) {
            if (isPrime(Integer.parseInt(numberString))) {
                amazingPrimeList.add(numberString);
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            String next = numberString + i;
            if (isPrime(Integer.parseInt(next))) {
                dfs(next);
            }
        }
    }
}