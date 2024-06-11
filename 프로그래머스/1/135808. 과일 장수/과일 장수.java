import java.util.*;

class Solution {
    
    
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);  //오름차순 정렬
        
        int boxes  = score.length / m;
        int money = 0;
        for (int i = 1; i <= boxes; i++) {
            answer += score[score.length - i * m] * m;
        }
        
        
        return answer;
    }
}