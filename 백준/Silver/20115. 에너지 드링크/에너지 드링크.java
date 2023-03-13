import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int drinks = in.nextInt();
        double totalC = 0;
        Double[] caps = new Double[drinks];

        for(int i= 0; i < drinks; i++)
            caps[i] = in.nextDouble();

        Arrays.sort(caps, Collections.reverseOrder());

        totalC += caps[0];
        for(int i = 1; i < drinks; i++) {
            totalC += caps[i] / 2;
        }

        System.out.println(totalC);
    }
}