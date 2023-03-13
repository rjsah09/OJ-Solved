import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String question = in.nextLine();
        boolean isSub = false;
        int result = 0; //최종 결과값

        String num = "";
        for(int i = 0; i < question.length(); i++) {
            if(Character.isDigit(question.charAt(i))) {
                num += question.charAt(i);
            } else {//+ or -
                if(question.charAt(i) == '+' && isSub == false){
                    result += Integer.parseInt(num);
                } else if(question.charAt(i) == '-' && isSub == false){
                    isSub = !isSub;
                    result += Integer.parseInt(num);
                }
                else {
                    result -= Integer.parseInt(num);
                }
                num = "";
            }
        }
        if(!isSub)
            result += Integer.parseInt(num);
        else
            result -= Integer.parseInt(num);


        System.out.println(result);
    }
}