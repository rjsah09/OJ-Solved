class Solution {
    public int solution(int x, int y, int n) {
        int[] dp = new int[y + 1];
        dp[x] = 1;
        
        for (int i = x + 1; i <= y; i++) {
            //값 후보 {i / 3, i / 2, i - 3}
            int div3 = (i % 3 != 0) || (i / 3 < x) || (dp[i / 3] == Integer.MAX_VALUE) ? Integer.MAX_VALUE : dp[i / 3] + 1;
            int div2 = (i % 2 != 0) || (i / 2 < x) || (dp[i / 2] == Integer.MAX_VALUE) ? Integer.MAX_VALUE : dp[i / 2] + 1;
            int subN = (i - n < x) || (dp[i - n] == Integer.MAX_VALUE) ? Integer.MAX_VALUE : dp[i - n] + 1;
            
            //값 선택하기
            dp[i] = Math.min(Math.min(div3, div2), subN);
        }
        
        if (dp[y] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dp[y] - 1;
        }
    }
}