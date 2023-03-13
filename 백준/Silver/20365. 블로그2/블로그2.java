
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int pList = in.nextInt();
        String color = in.next();
        int result;

        //총 개수가 아닌 연속 횟수를 체크
        int red = 0; int blue = 0;
        char prev;

        //초기값
        if(color.charAt(0) == 'R'){
            prev = 'R';
            red++;
        }
        else {
            prev = 'B';
            blue++;
        }

        for(int i = 1; i < pList; i++) {
            if(color.charAt(i) != prev){
                if(color.charAt(i) == 'R')
                    red++;
                else
                    blue++;
            }
            prev = color.charAt(i);
        }
        if(red > blue)
            result = blue + 1;
        else
            result = red + 1;

        System.out.println(result);
    }
}
