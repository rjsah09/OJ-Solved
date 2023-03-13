import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //ax +by = c
        //dx + ey = f
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int d = in.nextInt();
        int e = in.nextInt();
        int f = in.nextInt();
        int result;

        for(int i = -999; i <=999; i++) {
            for(int j = -999; j <= 999; j++){
                int sumA = a * i + b * j;
                int sumB = d * i + e * j;
                if(sumA == c && sumB == f)
                    System.out.println(i + " " + j);
            }
        }
    }
}