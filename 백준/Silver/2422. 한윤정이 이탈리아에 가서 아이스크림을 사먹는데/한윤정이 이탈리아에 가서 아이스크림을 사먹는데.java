import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int ice = in.nextInt();
        int noMix = in.nextInt();
        boolean[][] combi = new boolean[ice + 1][ice + 1];

        for(int i = 0; i < noMix; i++) {
            int pick1 = in.nextInt();
            int pick2 = in.nextInt();
            combi[pick1][pick2] = true;
            combi[pick2][pick1] = true;
        }

        int result = 0;
        for(int i = 1; i <= ice - 2; i++) {
            for(int j = i + 1; j <= ice - 1; j++) {
                for(int k = j + 1; k <= ice; k++) {
                    if(combi[i][j] || combi[i][k] || combi[j][k]) continue;
                    else result++;

                }
            }
        }

        System.out.println(result);
    }

}