import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        //감소 for문
        for(int i = citations.length - 1; i >= 0; i--) { //index = i
            
            int index = 0;  //인덱스 조건에 부합하는 배열의 원소의 개수
            for(int j = citations.length - 1; j >= 0; j--) {    //끝에서부터 처음까지 확인
                if(citations[j] >= i + 1)
                    index++;
            }
            
            if(index >= i)  //인덱스의 개수가 i보다 높다면(H-Index를 만족한다면)
                return index;
        }
        
        return answer;
    }
}