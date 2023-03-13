import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String pan = in.nextLine(); //입력 받을 문자
        String res = "";

        int canA = 0;
        int canB = 0;
        int count = 0;  //'.'을 만날때까지 길이를 카운트 할 변수

        for(int i = 0; i < pan.length(); i++) {   //pan 길이동안 문자별 반복
            if(pan.charAt(i) == 'X'){  //X라면 AAAA나 BB를 끼울 수 있으므로 count++
                count++;
            } else {    //'.'인 경우 구해진 카운트를 바탕으로 끼우기 계산
                canA = count / 4;

                canB = count % 4;

                if(canB % 2 != 0) {
                    System.out.println("-1");
                    return;
                }

                res += "AAAA".repeat(canA) + "BB".repeat(canB/2) + ".";
                count = 0;
                canA = canB = 0;
            }

        }
        if(count != 0){
            canA = count / 4;

            canB = count % 4;

            if(canB % 2 != 0) {
                System.out.println("-1");
                return;
            }
            res += "AAAA".repeat(canA) + "BB".repeat(canB/2);
            count = 0;
            canA = canB = 0;
        }

        System.out.println(res);
    }

}