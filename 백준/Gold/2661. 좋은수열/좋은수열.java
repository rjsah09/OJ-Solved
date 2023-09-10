import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static String minGoodSeq;

    static boolean found;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        found = false;

        minGoodSeq = "9".repeat(80);

        dfs("");

        System.out.println(minGoodSeq);
    }

    static void dfs(String sequence) {
        if (found) {
            return;
        }

        if (sequence.length() == N) {
            minGoodSeq = minGoodSeq.compareTo(sequence) < 0 ? minGoodSeq : sequence;
            found = true;
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (!isDuplicated(sequence + i)) {
                dfs(sequence + i);
            }
        }


    }

    static boolean isDuplicated(String now) {

        for (int i = 0; i < now.length(); i++) {    //시작 위치
            for (int j = 1; i + j * 2 <= now.length(); j++) {    //확인 길이
                String sub1 = now.substring(i, i + j);
                String sub2 = now.substring(i + j, i + j * 2);
                if (sub1.equals(sub2)) {
                    return true;
                }
            }
        }

        return false;
    }
}