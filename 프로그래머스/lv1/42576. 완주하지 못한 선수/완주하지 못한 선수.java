import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        //정렬
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        //같은 인덱스에서 같은 값이 나오지 않으면 해당 인덱스의 participant가 탈락자
        for(int i = 0; i < completion.length; i++){
            if(!participant[i].equals(completion[i]))
                return participant[i];
        }
        //마지막 인덱스의 선수가 탈락자인경우
        return participant[participant.length - 1]; 
    }
}