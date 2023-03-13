import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            int[] nums = new int[m];
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            for(int j = 0; j < m; j++)
                nums[j] = Integer.parseInt(st.nextToken());
            Arrays.sort(nums);
            System.out.println(nums[0] + " " + nums[m - 1]);
        }
    }
}