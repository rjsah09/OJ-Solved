import java.util.Scanner;

public class Main{
    public static void main(String args[]){
        Scanner out = new Scanner(System.in);
        int tCase = Integer.parseInt(out.nextLine());
        String[] strs = new String[tCase];

        for(int i = 0; i < tCase; i++) {
            strs[i] = out.nextLine();
        }
        for(String s : strs) {
            int rep = s.charAt(0) - 48;
            for(int i = 2; i < s.length(); i++){
                for(int j = 0; j <rep; j++)
                    System.out.print(s.charAt(i));
            }
            System.out.println("");
        }
    }
}