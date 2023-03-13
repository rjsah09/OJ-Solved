import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int participants = in.nextInt();    //참가자
        int coNum = in.nextInt();   //뻔데기 횟수
        int bOrD = in.nextInt();    //뻔이나 데기 선택

        int i = 0; //사람
        int count = 0; //n번째 번 혹은 데기
        int progress = 0;   //번데기 회차 내 진행
        int stage = 2;  //번데기 단계 : 1단계부터 번번데기데기 이므로 2부터 시작
        while(count < coNum){
            int tmp;

            //번인지 데기인지 체크
            if(progress <= 3) {  //한 회차의 4번 까지
                if (progress % 2 == 0)   //짝수면 번
                    tmp = 0;
                else    //홀수면 데기
                    tmp = 1;
            } else {
                if (progress > 3 && progress <= (3 + stage) )
                    tmp  = 0;
                else
                    tmp = 1;
            }

            //번이나 데기가 나옴에 따라 카운트 증가
            if(tmp == bOrD)
                count++;

            //System.out.println(i + "번째 사람 : " + tmp);

            //한 명이 차례를 끝내면
            if(i >= participants - 1)    //다음 인원으로 변경
                i = 0;
            else
                i++;

            if(progress >= 3 + stage * 2){  //게임의 진행
                progress = 0;
                stage++;
            } else
                progress++;
        }

        if(i == 0)
            System.out.println(participants - 1);
        else
            System.out.println(i - 1);
    }
}
