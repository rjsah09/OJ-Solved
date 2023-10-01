import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        List<String> croatianAlphabetList = Arrays.asList("c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=");

        for (int i = 0; i < croatianAlphabetList.size(); i++) {
            line = line.replaceAll(croatianAlphabetList.get(i), "!");
        }

        System.out.println(line.length());

    }
}