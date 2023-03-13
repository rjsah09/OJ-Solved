import java.util.Scanner;

public class Main{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int bags, left;

        bags = N / 5;
        left = N - bags * 5;

        while(left % 3 != 0) {
            if(bags <= 0){
                System.out.println(-1);
                return;
            } else {
                bags--;
                left += 5;
            }
        }

        bags += left / 3;
        System.out.println(bags);
    }
}