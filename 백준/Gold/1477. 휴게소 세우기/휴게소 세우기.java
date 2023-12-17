import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //갖고 있는 휴게소 수
        int M = Integer.parseInt(st.nextToken());   //추가로 세우려는 휴게소 수
        int L = Integer.parseInt(st.nextToken());   //고속도로의 길이
        int[] positions = new int[N + 2];
        int min = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            positions[i] = Integer.parseInt(st.nextToken());
        }
        positions[0] = 0;
        positions[N + 1] = L;
        Arrays.sort(positions);

        int start = 1;
        int end = L - 1;

        while (start <= end) {
            int mid = (start + end) / 2;    //편의점 사이의 최대 거리
            int addedStopCount = 0; //마지막 위치에서 다음 위치까지 center 보다 큰 경우 마지막 위치에서 center 거리 차이에 설치하면 됨

            for (int i = 1; i < positions.length; i++) {
                int diff = positions[i] - positions[i - 1] - 1; //거리 차이
                addedStopCount += diff / mid;   //기존의 편의점 거리 사이에 mid 만큼의 편의점을 몇개 설치할 수 있는지
            }
            //System.out.println("start = " + start + ", end = " + end + ", mid = " + mid);
            //System.out.println("mid 값이 " + mid + " 일 때세운 휴게소는 " + addedStopCount);

            if (addedStopCount > M) {   //세울 수 있는 주유소 개수가 M개 보다 많다 => 최대 거리를 늘릴 수 있다
                start = mid + 1;
            } else {    //최대 거리를 줄여야 한다
                min = Math.min(mid, min);
                end = mid - 1;
            }
        }

        //System.out.println("시작 = " + start + ", 끝 = " + end);

        System.out.println(min);
    }
}