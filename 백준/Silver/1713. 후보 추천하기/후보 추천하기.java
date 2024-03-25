import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static List<int[]> frameList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());    //사진 틀 개수
        M = Integer.parseInt(br.readLine());    //총 추천 수
        frameList = new ArrayList<>(); //사진에 걸린 순서로 저장, (item, item)

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int recommended = Integer.parseInt(st.nextToken());

            if (frameList.size() >= N && containsCandidate(recommended) == -1) {
                deleteRecommended();
            }

            int index = containsCandidate(recommended);
            if (index == -1) {
                frameList.add(new int[]{recommended, 1});
            } else {
                frameList.get(index)[1]++;
            }
        }

        frameList.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < frameList.size(); i++) {
            sb.append(frameList.get(i)[0] + " ");
        }

        System.out.println(sb);
    }

    static int containsCandidate(int recommended) {
        for (int i = 0; i < frameList.size(); i++) {
            if (frameList.get(i)[0] == recommended) {
                return i;
            }
        }

        return -1;
    }

    static void deleteRecommended() {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < frameList.size(); i++) {
            min = Math.min(min, frameList.get(i)[1]);
        }

        for (int i = 0; i < frameList.size(); i++) {
            if (frameList.get(i)[1] == min) {
                frameList.remove(i);
                return;
            }
        }
    }

}
