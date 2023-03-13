import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int input = in.nextInt();
        int maker = 0, result = 1000001;

        for(int i = 0; i <= input; i++) {
            maker += i;

            int left = i;
            while(left > 0) {
                maker += left % 10;
                left /= 10;
            }

            if(maker == input && i < result)
                result = i;
            maker = 0;
        }
        
        if(result == 1000001)
            System.out.println(0);
        else
            System.out.println(result);
    }
}