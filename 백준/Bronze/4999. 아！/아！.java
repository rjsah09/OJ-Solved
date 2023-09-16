import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int saidLength = br.readLine().length();
        int inquiryLength = br.readLine().length();

        String result = saidLength >= inquiryLength ? "go" : "no";
        System.out.println(result);
    }
}
