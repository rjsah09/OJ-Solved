import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> map = Map.of(
                "NLCS", "North London Collegiate School",
                "BHA", "Branksome Hall Asia",
                "KIS", "Korea International School",
                "SJA", "St. Johnsbury Academy"
        );

        System.out.println(map.get(br.readLine()));
    }
}
