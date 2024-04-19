class Solution {
    public long solution(int n, int[] times) {
        long answer = Integer.MAX_VALUE;
        
        long start = Long.MAX_VALUE;
        for (int i = 0; i < times.length; i++) {
            start = Math.min(start, times[i]);
        }
        
        long end = start * n;
        
        //System.out.println("최댓값 = " + start + ", 최솟값 = " + end);
        
        while (start <= end) {
            long mid = (start + end) / 2;    //한 명의 심사관이 모든 심사를 끝내는데 걸리는 시간
            
            long count = 0;
            for (int i = 0; i < times.length; i++) {
                count += mid / times[i];
            }
            //System.out.println(mid + "시간 안에 끝낼 수 있는 사람 = " + count);
            
            if (count >= n) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return answer;
    }
}