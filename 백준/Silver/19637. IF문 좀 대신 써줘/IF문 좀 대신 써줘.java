import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<Integer> valueCutList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //칭호 갯수
        int M = Integer.parseInt(st.nextToken());   //캐릭터 갯수
        Map<Integer, String> valueMap = new HashMap<>();
        valueCutList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int value = Integer.parseInt(st.nextToken());
            if (!valueMap.containsKey(value)) {
                valueCutList.add(value);
                valueMap.put(value, name);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int valueCut = getValueCut(Integer.parseInt(br.readLine()));
            sb.append(valueMap.get(valueCut)).append("\n");
        }

        System.out.println(sb);
    }

    static int getValueCut(int value) {
        int start = 0;
        int end = valueCutList.size() - 1;
        int valueCut = Integer.MAX_VALUE;

        while (start <= end) {
            int center = (start + end) / 2;
            int centerValue = valueCutList.get(center);

            if (centerValue >= value) {
                valueCut = Math.min(centerValue, valueCut);
                end = center - 1;
            } else {
                start = center + 1;
            }
        }

        return valueCut;
    }
}
