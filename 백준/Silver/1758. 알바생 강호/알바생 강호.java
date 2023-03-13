import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int people = in.nextInt();  //총 인원
        long totalTip = 0;
        Integer[] tips = new Integer[people];

        for (int i = 0; i < people; i++) {
            tips[i] = in.nextInt();     //인원별 팁 가격
        }

        Arrays.sort(tips, Collections.reverseOrder());  //정렬

        for(int i = 0; i < people; i++) {
            int tip = tips[i] - i;
            if(tip <= 0)
                tip = 0;
            totalTip += tip;
        }

        System.out.println(totalTip);

    }
}