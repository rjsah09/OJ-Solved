import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //악보 수
        int Q = Integer.parseInt(st.nextToken());   //질문 수

        ArrayList<Integer> musics = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int length = Integer.parseInt(br.readLine());
            for (int j = 0; j < length; j++) {
                musics.add(i + 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int question = Integer.parseInt(br.readLine());
            sb.append(musics.get(question) + "\n");
        }

        System.out.println(sb);
    }
}