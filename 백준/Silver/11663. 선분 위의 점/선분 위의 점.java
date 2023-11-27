import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] points;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        points =  new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            points[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(points);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            //System.out.println("시작 인덱스 = " + startCut + ", 끝 인덱스 = " +  endCut);
            if (isAllOutOfRange(start, end)) {
                sb.append(0).append("\n");
            } else {
                int startCut = getClosePointIndex(start, true);
                int endCut = getClosePointIndex(end, false);
                sb.append(endCut - startCut + 1).append('\n');
            }
        }

        System.out.println(sb);
    }

    static int getClosePointIndex(int point, boolean isStart) {
        int start = 0;
        int end = points.length - 1;
        int pointCut = isStart ? Integer.MAX_VALUE : 0;

        while (start <= end) {
            int center = (start + end) / 2;
            int centervalue =points[center];

            if (centervalue > point) {
                if (isStart) {
                    pointCut = Math.min(pointCut, center);
                }

                end = center - 1;
            } else if (centervalue < point) {
                if (!isStart) {
                    pointCut = Math.max(pointCut, center);
                }
                start = center + 1;
            } else {
                if (isStart) {
                    pointCut = Math.min(pointCut, center);
                    end = center - 1;
                } else {
                    pointCut = Math.max(pointCut, center);
                    start = center + 1;
                }
            }
        }

        return pointCut;
    }

    static boolean isAllOutOfRange(int start, int end) {
        int minPoint = points[0];
        int maxPoint = points[points.length - 1];

        if (end < minPoint || start > maxPoint) {
            return true;
        }

        return false;
    }
}
