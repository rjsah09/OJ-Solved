import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int ropeValue = in.nextInt();   //로프의 개수 입력
        int[] ropes = new int[ropeValue];

        //로프 배열 채우기
        for(int i = 0; i < ropeValue; i++)
            ropes[i] = in.nextInt();

        Arrays.sort(ropes);
        int maxWeight = 0;
        int count = 0;
        for(int i = ropeValue; i > 0 ; i--) {
            int weight;
            count++;
            weight = ropes[i - 1] * (ropeValue - i + 1);
            if(weight > maxWeight)
                maxWeight = weight;
        }

        System.out.println(maxWeight);
    }
}
