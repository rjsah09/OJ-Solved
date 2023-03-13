import java.util.Scanner;

public class Main{
    public static void main(String args[]){
        Scanner out = new Scanner(System.in);
        int n = out.nextInt();


        String input = out.next();
        int res = 0;
        for(int i = 0; i < n; i++){
            //System.out.println((int)input.charAt(i) - 48);
            res += (int)input.charAt(i) - 48;
        }
        System.out.println(res);
    }
}