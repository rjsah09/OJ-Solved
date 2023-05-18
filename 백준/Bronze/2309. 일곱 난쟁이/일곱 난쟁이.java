import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] heights = new int[9];

        int total = 0;
        for (int i = 0; i < 9; i++) {
            int height = Integer.parseInt(br.readLine());
            heights[i] = height;
            total += height;
        }
        Arrays.sort(heights);

        int[] wrongIdx = getWrongIdx(heights, total);
        heights[wrongIdx[0]] = heights[wrongIdx[1]] = 0;

        for (int i = 0; i < 9; i++) {
            if (heights[i] == 0) {
                continue;
            }

            System.out.println(heights[i]);
        }
    }

    public static int[] getWrongIdx(int[] heights, int total) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i == j) {
                    continue;
                }

                if (total - heights[i] - heights[j] == 100) {
                    heights[i] = heights[j] = 0;
                    return new int[] {i, j};
                }
            }
        }

        return new int[] {-1, -1};
    }
}
