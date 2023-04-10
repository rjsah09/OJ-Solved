class Solution {
    public long solution(int price, int money, int count) {
        long[] dp = new long[count + 1];
        
        dp[1] = price;
        for (int i = 2; i <= count; i++) {
            dp[i] = dp[i - 1] + i * price;
        }

        long left = dp[count] - money;
        return left > 0 ? left : 0;
    }
}