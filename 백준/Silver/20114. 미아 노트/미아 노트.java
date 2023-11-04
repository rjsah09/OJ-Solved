import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        String[] spreadWords = new String[H];
        char[] original = new char[N];
        Arrays.fill(original, '?');

        for (int i = 0; i < H; i++) {
            spreadWords[i] = br.readLine();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < W; j++) {
                for (int k = 0; k < H; k++) {
                    char letter = spreadWords[k].charAt(W * i + j);
                    if (letter != '?') {
                        original[i] = letter;
                    }
                }
            }
        }

        System.out.println(String.valueOf(original));
    }
}