import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String code = in.nextLine();
        String max = "";
        String min = "";

        int count = -1;
        for(int i = 0; i < code.length(); i++) {
            if(code.charAt(i) == 'M'){
                if(i == code.length() - 1) {
                    count++;
                    max += "1".repeat(count + 1);
                    //min += Long.toString((long)(Math.pow(10, count)));
                    min += "1";
                    for(int j = 0; j < count; j++){
                        min += "0";
                    }
                } else
                    count++;
            } else if(code.charAt(i) == 'K') {
                if(count >= 0) {
                    max += "5" + "0".repeat(count + 1);
                    min += "1";
                    for(int j = 0; j < count; j++){
                        min += "0";
                    }
                    min += "5";
                    //min += Integer.toString((int)Math.pow(10, count)) + "5";
                }
                else {
                    min += "5";
                    max += "5";
                }
                count = -1;
            }
        }

        System.out.println(max);
        System.out.println(min);
    }
}