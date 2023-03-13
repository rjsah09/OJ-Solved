import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        ArrayList<Integer> q = new ArrayList<>();

        for(int i = 0; i < priorities.length; i++)
            q.add(i);
        
        outerloop :
        while(!q.isEmpty()) {
            for(int i = 1; i < q.size(); i++){  //뒤에 우선순위가 있다면 뒤로 미는 로직
                if(priorities[q.get(0)] < priorities[q.get(i)]) {
                    q.add(q.get(0));
                    q.remove(0);
                    continue outerloop;
                }
            }
            
            if(q.get(0) == location)
                return answer;
            else {
                answer++;
                q.remove(0);
            }
                
        }
        return answer;
    }
}