import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] cards = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(cards, target) + " ");
        }

        System.out.println(sb);
    }

    static int binarySearch(int[] cards, int target) {
        int lowIndex = 0;
        int highIndex = cards.length - 1;

        while (lowIndex <= highIndex) {
            int centerIndex = (lowIndex + highIndex) / 2;
            if (cards[centerIndex] == target) {
                return 1;
            } else if (cards[centerIndex] < target) {
                lowIndex = centerIndex + 1;
            } else {
                highIndex = centerIndex - 1;
            }
        }

        return 0;
    }
}
