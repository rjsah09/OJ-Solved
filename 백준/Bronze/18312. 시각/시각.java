import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int limit = in.nextInt();
        String check = in.next();
        int result = 0;
        String hour, min, sec;

        for(int i = 0; i <= limit; i++){    //시
            for(int j = 0; j < 60; j++){    //분
                for(int k = 0; k < 60; k++) { //초
                    if (i < 10)
                        hour = "0" + i;
                    else
                        hour = Integer.toString(i);

                    if (j < 10)
                        min = "0" + j;
                    else
                        min = Integer.toString(j);

                    if (k < 10)
                        sec = "0" + k;
                    else
                        sec = Integer.toString(k);

                    if (hour.contains(check) || min.contains(check) || sec.contains(check))
                        result++;
                }
            }
        }

        System.out.println(result);
    }
}
