import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int patternSize = 1 + (input - 1) * 4;
        boolean[][] pattern = new boolean[patternSize][patternSize];

        pattern[patternSize/2][patternSize/2] = true;
        for(int i = 0; i < input - 1; i++) {
            int pos1 = 2 * i;
            int pos2 = patternSize - 2 * i - 1;
            for(int j = pos1; j < pos2 + 1; j++) {
                pattern[pos1][j] = true;
                pattern[pos2][j] = true;
            }
            for(int j = pos1 + 1; j < pos2; j++) {
                pattern[j][pos1] = true;
                pattern[j][pos2] = true;
            }
        }

        StringBuilder st = new StringBuilder();
        for(int i = 0; i < pattern.length; i++) {
            for(int j = 0; j < pattern.length; j++) {
                if(pattern[i][j])
                    st.append("*");
                else
                    st.append(" ");
            }
            st.append("\n");
        }
        System.out.println(st);
    }
}