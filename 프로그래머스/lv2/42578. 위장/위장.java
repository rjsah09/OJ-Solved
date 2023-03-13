import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < clothes.length; i++) //옷을 입지 않는 경우
            map.put(clothes[i][1], 1);
        
        for(int i = 0; i < clothes.length; i++) //옷을 카테고리에 맞춰 넣음
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);  //<카테고리, 옷의 이름>
        
        //1. keySet()
        /*
        //옷을 안입는 경우를 추가해 뽑기 (c1 + 1) * (c2 + 1) +.....+(cn + 1)
        for(String category : map.keySet()) {
            answer *= map.get(category);
        }*/
        
        //2. Iterator()
        Iterator<String> iter = map.keySet().iterator();
        while(iter.hasNext()) {     //iterator의 다음이 있다면   
            answer *= map.get(iter.next());
        }
        
        answer--;
        
        return answer;
    }
}