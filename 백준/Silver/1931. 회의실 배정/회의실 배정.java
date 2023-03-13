import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int meetings = in.nextInt();
        int mtList[][] = new int[meetings][2];
        int result = 0;

        for (int i = 0; i < meetings; i++) {
            mtList[i][0] = in.nextInt();
            mtList[i][1] = in.nextInt();
        }

        Arrays.sort(mtList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                } else
                    return o1[1] - o2[1];
            }

        });

        int endTime = 0;
        for(int i = 0; i < meetings; i++) {
            if(endTime <= mtList[i][0]) {
                result++;
                endTime = mtList[i][1];
            }
        }

        System.out.println(result);
    }
}
