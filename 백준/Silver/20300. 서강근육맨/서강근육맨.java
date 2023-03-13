import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int machines = in.nextInt();
        long max = 0;
        Long[] losts = new Long[machines];

        for(int i = 0; i < machines; i++)
            losts[i] = in.nextLong();

        Arrays.sort(losts);

        if(machines % 2 == 0)
            for(int i = 0; i < machines / 2; i++){
               long lost = losts[i] + losts[machines - i - 1];
               if(lost > max)
                   max = lost;
            }
        else {
            max = losts[machines - 1];
            for (int i = 0; i < machines / 2; i++) {
                long lost = losts[i] + losts[machines - i - 2];
                if(lost > max)
                    max = lost;
            }
        }

        System.out.println(max);
    }
}