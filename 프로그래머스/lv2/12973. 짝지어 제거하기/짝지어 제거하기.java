import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        
        if(s.length() % 2 == 1)
            return 0;
        
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for(int i = 1; i < s.length(); i++) {
            char sub = s.charAt(i);
            if(stack.size() == 0)
                stack.push(sub);
            else {
                if(sub == stack.peek())
                    stack.pop();
                else
                    stack.push(sub);
            }
        }
        
        if(stack.size() == 0)
            return 1;
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println(stack.pop());

        return answer;
    }
}