import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());   //과자의 가격
        int N = Integer.parseInt(st.nextToken());   //과자의 개수
        int M = Integer.parseInt(st.nextToken());   //가진 돈

        int totalPrice = K * N;
        int lack = totalPrice - M > 0 ? totalPrice - M : 0;

        System.out.println(lack);
    }
}
