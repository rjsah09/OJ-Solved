import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for(int i = 0; i < scoville.length; i++) {
            q.add(scoville[i]);
        }
        
        while(q.peek() < K && q.size() >= 2) {
            int lowest = q.poll();
            int second = q.poll();
            
            int total = lowest + second * 2;
            q.add(total);
            answer++;
        }
        
        if(q.peek() >= K)
            return answer;
        else
            return -1;
    }
}