import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String credit = br.readLine();
        Map<String, String> creditMap = new HashMap<>();
        creditMap.put("A+", "4.3");
        creditMap.put("A0", "4.0");
        creditMap.put("A-", "3.7");
        creditMap.put("B+", "3.3");
        creditMap.put("B0", "3.0");
        creditMap.put("B-", "2.7");
        creditMap.put("C+", "2.3");
        creditMap.put("C0", "2.0");
        creditMap.put("C-", "1.7");
        creditMap.put("D+", "1.3");
        creditMap.put("D0", "1.0");
        creditMap.put("D-", "0.7");
        creditMap.put("F", "0.0");

        System.out.println(creditMap.get(credit));
    }
}