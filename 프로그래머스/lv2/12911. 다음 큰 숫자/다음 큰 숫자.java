class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for (int i = n + 1; i <= 1000000; i++) {
            if (isBigger(n, i) && hasSameOne(n, i)) {
                return i;                
            }
        }
        
        return answer;
    }
    
    public boolean isBigger(int n, int bigger) {
        return bigger > n;
    }
    
    public boolean hasSameOne(int n, int bigger) {
        int nOne = getNumberOfOne(n);
        int biggerOne = getNumberOfOne(bigger);
        
        return nOne == biggerOne;
    }
    
    public int getNumberOfOne(int n) {
        String binaryString = Integer.toBinaryString(n);
        
        int oneCount = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            char c = binaryString.charAt(i);
            if (c == '1') {
                oneCount++;
            }
        }
        
        return oneCount;
    }
}