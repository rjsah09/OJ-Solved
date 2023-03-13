import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int tph = in.nextInt(); //A : 시간 당 누적 피로도
        int jph = in.nextInt(); //B : 시간 당 작업 처리
        int cph = in.nextInt(); //C : 휴식시 시간당 피로 회복
        int limit = in.nextInt(); //D : 피로도 제한

        int tired = 0;  //현재 피로도
        int processed = 0;

        if(tph > limit) {
            System.out.println(0);
            return;
        }

        for(int i = 0; i < 24; i++) {
            if(tired + tph <= limit){   //피로 제한을 넘지 않으면 1시간 일을 수행
                tired += tph;
                processed += jph;
            } else {    //피로 제한을 넘기면 1시간 휴식
                tired -= cph;
                if(tired < 0)
                    tired = 0;
            }
        }

        System.out.println(processed);
    }
}