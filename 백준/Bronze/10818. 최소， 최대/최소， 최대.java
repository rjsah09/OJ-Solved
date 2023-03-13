import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] input = new int[n];
        for(int i = 0; i < n; i++) input[i] = in.nextInt();

        Arrays.sort(input);
        System.out.println(input[0] + " " + input[n - 1]);
    }
}