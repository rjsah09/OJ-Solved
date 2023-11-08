import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String[] totalHowling = br.readLine().split(" ");
            String line = br.readLine();
            while (!line.equals("what does the fox say?")) {
                StringTokenizer st = new StringTokenizer(line);
                String animal = st.nextToken();
                String goes = st.nextToken();
                String howling = st.nextToken();
                for (int j = 0; j < totalHowling.length; j++) {
                    if (totalHowling[j].equals(howling)) {
                        totalHowling[j] = "";
                    }
                }

                line = br.readLine();
            }

            for (int j = 0; j < totalHowling.length; j++) {
                if (!totalHowling[j].equals("")) {
                    sb.append(totalHowling[j] + " ");
                }
            }
        }
        
        System.out.println(sb);
    }
}