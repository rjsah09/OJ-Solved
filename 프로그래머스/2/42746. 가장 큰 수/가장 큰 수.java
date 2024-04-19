import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        int zeroCount = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                zeroCount++;
            }
        }
        
        if (zeroCount == numbers.length) {
            return "0";
        }
        
        String[] nums = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = "" + numbers[i];
        }
        Arrays.sort(nums, new Comparator<String>() {
            public int compare(String o1, String o2) {
                int num1 = Integer.parseInt(o1 + o2);
                int num2 = Integer.parseInt(o2 + o1);
                
                return num2 - num1;
            }
        });
        
        for (String num: nums) {
            answer += num;
        }
        
        return answer;
    }
}