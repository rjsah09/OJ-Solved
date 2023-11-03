import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int totalSec = 0;
        for (int i = 2; i >= 0; i--) {
            totalSec += (int) (Integer.parseInt(st.nextToken()) * Math.pow(60, i));
        }
        totalSec += Integer.parseInt(br.readLine());

        int hour = (totalSec / 3600) % 24;
        totalSec %= 3600;
        int min = totalSec / 60;
        totalSec %= 60;
        int sec = totalSec;

        System.out.println(hour + " " + min + " " + sec);
    }
}
