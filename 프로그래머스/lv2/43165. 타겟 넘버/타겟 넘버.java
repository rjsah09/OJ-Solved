import java.util.*;

class Solution {
    int answer = 0;
    int target;
    int[] numbers;
    int end;
    
    public int solution(int[] numbers, int target) {
        this.target = target;
        this.numbers = numbers;
        end = numbers.length;   //마지막 레벨(0에서 시작)
        travel(0, 0, 0);
        
        return answer;
    }

    public void travel(int value, int level, int sum) {
        sum += value;    //이전의 값에 이번 노드의 값 더하기
        if(level != end) { //마지막 노드가 아니라면
            travel(numbers[level], level + 1, sum);
            travel(-numbers[level], level + 1, sum);
        } else {
            if(sum == target)
                answer++;
        }
    }
    
}