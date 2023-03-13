class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int[] wh = new int[2];    //(w, h)

        for(int i = 1; i <= yellow; i++) { //세로의 길이 = i;
            if(yellow % i > 0) 
                continue;
            
            wh[0] = yellow / i; //가로
            wh[1] = i;  //세로
            
            if((wh[0] * 2) + (wh[1] * 2) + 4 == brown) {
                answer[0] = wh[0] + 2;
                answer[1] = wh[1] + 2;
                break;
            }
        }
        
        return answer;
    }
    
}