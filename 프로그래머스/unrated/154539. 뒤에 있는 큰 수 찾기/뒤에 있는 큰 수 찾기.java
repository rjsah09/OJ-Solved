import java.util.LinkedList;
import java.util.Stack;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numbers.length; i++) {
            if (!stack.isEmpty() && numbers[i] > numbers[i - 1]) {
                while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                    answer[stack.pop()] = numbers[i];
                }
            }
            
            stack.add(i);
        }
        
        //마지막으로 큐에 남아있는 값은 뒤에 있는 큰 수가 존재하지 않는값이므로 -1로 초기화 
        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }
        
        return answer;
    }
}