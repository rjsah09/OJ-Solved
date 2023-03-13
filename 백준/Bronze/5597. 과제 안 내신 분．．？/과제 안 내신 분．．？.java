import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] passed = new boolean[30];

        for(int i = 0; i < 28; i++)
            passed[Integer.parseInt(br.readLine()) - 1] = true;

        for(int i = 0; i < 30; i++)
            if(!passed[i]) System.out.println(i + 1);
    }
}
