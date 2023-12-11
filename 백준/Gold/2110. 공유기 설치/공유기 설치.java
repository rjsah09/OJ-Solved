import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //집의 개수
        int C = Integer.parseInt(st.nextToken());   //공유기의 개수
        int[] houses = new int[N];
        int result = 0;
        int start = Integer.MAX_VALUE;
        int end = 0;

        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(houses);

        for (int i = 1; i < N; i++) {
            int diff = houses[i] - houses[i - 1];
            start = Math.min(start, diff);
            end += diff;
        }

        //System.out.println("start = " + start + ", end = " + end);

        while (start <= end) {
            int mid = (start + end) / 2;    //두 집 사이의 최소 거리 차(= diffList.get(i))
            //System.out.println("---------mid = " + mid + "-----------");

            int routerCount = 1;
            int lastSetIndex = 0;
            int min = Integer.MAX_VALUE;
            //System.out.println("0에 설치");
            for (int i = 1; i < N; i++) {
                int diff = houses[i] - houses[lastSetIndex];
                if (diff >= mid) {
                    //System.out.println(i + "에 설치");
                    min = Math.min(diff, min);
                    lastSetIndex = i;
                    routerCount++;
                }
            }
            //System.out.println("mid = " + mid + ", min = " + min + ", router = " + routerCount);

            if (routerCount >= C) {
                result = Math.max(min, result);
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(result);
    }
}
