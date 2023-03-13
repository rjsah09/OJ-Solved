import java.util.Scanner;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        int words = 1;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ' ')
                words++;
        }
        if(str.charAt(0) == ' ')
            words--;
        if((str.charAt(str.length() - 1)) == ' ')
            words--;

        System.out.println(words);
    }
}