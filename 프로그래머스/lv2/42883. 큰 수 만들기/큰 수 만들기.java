class Solution {
    public String solution(String number, int k) {
        String answer = ""; //제출할 답안
        int size = number.length() - k; //구해질 자리수
        
        int max = 0;    //한번 자리수 탐색에서의 최대값(인덱스)
        for(int j = 1; j <= size; j++) {
            for(int i = max; i < k + j; i++){
                if(number.charAt(i) == '9'){
                    max = i;
                    break;
                }
                if(number.charAt(i) > number.charAt(max))
                    max = i;
            }
            
            answer += number.charAt(max);            
            max++;
        }
        
        return answer;
    }
}