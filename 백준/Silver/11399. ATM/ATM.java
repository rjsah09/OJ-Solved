import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] times = new int[N];
        for(int i = 0; i < N; i++)
            times[i] = in.nextInt();

        //배열을 오름차순으로 설정하면 최소 시간
        Arrays.sort(times);

        int res = 0;
        int prev = 0;

        for(int time : times) {
            res += prev + time;
            prev += time;
        }

        System.out.println(res);
    }
}
