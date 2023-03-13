import java.util.Scanner;

public class Main {
    static int[] area = new int[2];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int answer = 0;
        area[0] = in.nextInt();
        area[1] = in.nextInt();
        int num = in.nextInt();
        int[][] sticker = new int[num][2];  //width, height;

        for(int i = 0; i < num; i++) {
            sticker[i][0] = in.nextInt();
            sticker[i][1] = in.nextInt();
        }

        for(int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (i == j) continue;

                if(isPass(sticker[i], sticker[j])) {
                    int result = sticker[i][0] * sticker[i][1] + sticker[j][0] * sticker[j][1];
                    if(answer < result) answer = result;
                }
            }
        }
        System.out.println(answer);
    }

    static boolean isPass(int[] s1, int[] s2) {
        for(int i = 0; i < 3; i++) {
            int width, height;
            if(i < 2) {
                width = s1[i] + s2[i];
                height = Math.max(s1[(i + 1) % 2], s2[(i + 1) % 2]);
            } else {
                width = s1[0] + s2[1];
                height = Math.max(s1[1], s2[0]);
            }

            if((width <= area[0] && height <= area[1]) || (width <= area[1] && height <= area[0]))
                return true;
        }
        return false;
    }
}