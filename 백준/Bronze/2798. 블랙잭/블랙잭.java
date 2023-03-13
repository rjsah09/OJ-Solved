import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int cards = in.nextInt();
        int limit = in.nextInt();
        Integer[] nums = new Integer[cards];
        int result = 0;
        for(int i= 0; i < cards; i++)
            nums[i] = in.nextInt();

        for(int i = 0; i < cards - 2; i++) {
            for(int j = i + 1; j < cards - 1; j++) {
                for(int k = j + 1; k < cards; k++) {
                    int added = nums[i] + nums[k] + nums[j];
                    if(added > result && added <= limit)
                        result = added;
                }
            }
        }

        System.out.println(result);
    }
}