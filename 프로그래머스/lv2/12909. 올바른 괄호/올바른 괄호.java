import java.util.Stack;

class Solution {
    boolean solution(String s) {
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(i, i  +1);
            if (sub.equals("(")) {
                stack.push(1);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        
        if (stack.isEmpty()) {
            return true;
        }

        return false;
    }
}