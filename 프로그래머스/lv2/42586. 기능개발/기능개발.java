import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        ArrayList<Integer> q = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList();
        
        for(int i = 0; i < progresses.length; i++)
            q.add(progresses[i]);    //큐에 배열 집어넣기
            
        
        int completed = 0;  //한번에 배포될 작업의 개수
        while(!q.isEmpty()) {
            for(int i = 0; i < q.size(); i++)    //기능 개발 진행
                q.set(i, q.get(i) + speeds[progresses.length - q.size() + i]);
            
            for(int i = 0; i < q.size(); i++) {
                if(q.get(0) >= 100) {
                    completed++;
                    q.remove(0);
                } else {
                    if(completed > 0){
                        ans.add(completed);
                        completed = 0;
                    }
                    break;
                }
            }
            
        }
        
        if(completed > 0)
            ans.add(completed);
        
        answer = new int[ans.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
}