import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int scheduleCount = Integer.parseInt(br.readLine());
        int[] schedules = new int[366];

        for (int i = 0; i < scheduleCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            for (int j = start; j <= end; j++) {
                schedules[j]++;
            }
        }

        //연속된 일정 * 스케줄이 가장 많은 날 = 하나의 종이
        int continuous = 0;
        int maxSchedulePerDay = 0;
        for (int i = 1; i <= 365; i++) {
            if (schedules[i] == 0) {
                answer += continuous * maxSchedulePerDay;
                continuous = maxSchedulePerDay = 0;
                continue;
            }

            continuous++;
            maxSchedulePerDay = Math.max(maxSchedulePerDay, schedules[i]);
        }
        answer += continuous * maxSchedulePerDay;

        System.out.println(answer);
    }
}