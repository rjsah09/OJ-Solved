import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Long, Long> map = new HashMap<>();
        
        for (int i = 0; i < weights.length; i++) {
            map.put((long)weights[i], map.getOrDefault((long)weights[i], 0L) + 1L);
        }
        
        long[] arr = new long[map.size()];
        int n = 0;
        for (Long num: map.keySet()) {
            if (map.get(num) > 1L) {
                answer += sumUntil(map.get(num));
            }
            arr[n++] = num;
        }
        
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (isBalance(arr[i], arr[j])) {
                    answer += map.get(arr[i]) * map.get(arr[j]);
                }
            }
        }
        
        return answer;
    }
    
    public boolean isBalance(long weightA, long weightB) {
        for (long i = 2L; i <= 4L; i++) {
            for (long j = 2L; j <= 4L; j++) {
                if (i * weightA == j * weightB) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public long sumUntil(long num) {
        long sum = 0;
        long idx = 1;
        while (idx < num) {
            sum += idx++;
        }
        return sum;
    }
}