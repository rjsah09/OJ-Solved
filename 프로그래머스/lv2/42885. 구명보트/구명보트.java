import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        //int limit : 보트의 무게제한
        //int[] people : 사람들의 무게
        final int length = people.length;   //인원수
        int answer = 0;     //최종 배의 개수
        
        Arrays.sort(people);    //오름차순으로 정렬
        
        int weight = 0;    //배의 무게
        int fIdx = 0;   //앞에서 세는 인덱스
        for(int i = length - 1; i >= fIdx; i--) {
            answer++;   //새로운 배를 도입
            weight = 0;    //무게 0으로 초기화
            weight += people[i];  //새로운 배에 i번째로 무거운 사람을 태움
            
            for(int j = fIdx; j < i; j++) {
                if(weight + people[j] <= limit) {
                    weight += people[j];
                    fIdx++;
                    break;
                }
                else
                    break;
            }
        }
        
        
        return answer;
    }
}