import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int dnaNum = in.nextInt();
        int dnaLength = in.nextInt();

        String[] code = new String[dnaNum];
        for(int i = 0; i < dnaNum; i++)
            code[i] = in.next();

        String result = "";
        int hamDist = 0;
        final char[] apb = {'A', 'C', 'G', 'T'};
        for(int i = 0; i < dnaLength; i++) {
            int count[] = new int[4];   //각 자리수가 얼마나 나오는지 체크, 각 인덱스는 A, C, G, T의 개수

            for(int j = 0; j < dnaNum; j++) {   //문자열 J의 I번 인덱스에 대한 카운트
                switch(code[j].charAt(i)){
                    case 'A' :
                        count[0]++;
                        break;
                    case 'C' :
                        count[1]++;
                        break;
                    case 'G' :
                        count[2]++;
                        break;
                    case 'T' :
                        count[3]++;
                        break;
                }
            }

            //맥스 체크
            int max = 0;
            char maxCh = 'A';
            for(int j = 0; j < 4; j++) {
                if(count[j] > max) {
                    hamDist += max; //맥스가 새로 바뀌는 경우, 기존의 맥스값을 더해주어야 함
                    max = count[j];
                    maxCh = apb[j];
                } else
                    hamDist += count[j];
            }
            result += maxCh;
        }

        System.out.println(result);
        System.out.println(hamDist);
    }
}