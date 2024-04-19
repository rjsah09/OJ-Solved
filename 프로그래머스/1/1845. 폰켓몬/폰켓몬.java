import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            map.put(number, map.getOrDefault(number, 0) + 1);
        }
        
        return map.size() >= nums.length / 2 ? nums.length / 2 : map.size();
    }
}