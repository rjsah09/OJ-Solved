import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String args[]){
        Scanner out = new Scanner(System.in);
        String str = out.next();
        int[] locs = new int[26];

        Arrays.fill(locs, -1);


        for(int i = 0; i < str.length(); i++){
            if(locs[(int)str.charAt(i) - 'a'] == -1)
                locs[(int)str.charAt(i) - 'a'] = i;
        }

        for(int i = 0; i < 26; i++) {
            System.out.print(locs[i]);
            if(i == 25)
                break;
            System.out.print(" ");
        }
    }
}