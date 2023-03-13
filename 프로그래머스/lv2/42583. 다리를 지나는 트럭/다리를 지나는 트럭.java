import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();   //남은 차 큐
        ArrayList<Integer> bridge = new ArrayList<>();  //도로의 차 배열
        int passed = 0; //통과한 차량 수
        
        for(int num : truck_weights) q.add(num);
        for(int i = 0; i < bridge_length; i++)  bridge.add(0);
        
        int idx = 0;    //출발 대기중인 차량의 번호
        while(passed < truck_weights.length) {
            answer++;   //시간 증가
            if(bridge.get(0) > 0) passed++;
            bridge.remove(0);
            
            int w = 0;
            for(int i = 0; i < bridge.size(); i++)  w += bridge.get(i);
            
            if(!q.isEmpty() && w + q.peek() <= weight){
                bridge.add(q.poll());
                continue;
            }
            bridge.add(0);
        }
        return answer;
    }
}