import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int count;
    static int r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());   //I index
        c = Integer.parseInt(st.nextToken());   //J index

        int half = (int) Math.pow(2, N)/ 2;
        if (r < half && c < half) { // 1분면
            trav(0, 0, half);
        } else if (r < half && c >= half) { //2분면
            count += half * half;
            trav(0, half, half);
        } else if (r >= half && c < half) { //3분면
            count += 2 * half * half;
            trav(half, 0, half);
        } else {
            count += 3 * half * half;
            trav(half, half, half);
        }

        System.out.println(count);
    }

    static void trav(int posI, int posJ, int size) {
        if (size > 1) {
            int half = size / 2;
            int maxI = posI + half;
            int maxJ = posJ + half;

            if (r < maxI && c < maxJ) { // 1분면
                trav(posI, posJ, half);
            } else if (r < maxI && c >= maxJ) { //2분면
                count += half * half;
                trav(posI, maxJ, half);
            } else if (r >= maxI && c < maxJ) { //3분면
                count += 2 * half * half;
                trav(maxI, posJ, half);
            } else {
                count += 3 * half * half;
                trav(maxI, maxJ, half);
            }
        }
    }
}
