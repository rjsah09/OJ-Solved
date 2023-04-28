class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        for (int i = 0; i < photo.length; i++) {
            //System.out.println(i + "번째 사진");
            int score = getScore(photo[i], name, yearning);
            answer[i] = score;
        }
        
        return answer;
    }
    
    public int getScore(String[] pic, String[] name, int[] yearning) {
        int score = 0;
        
        for (int i = 0; i < pic.length; i++) {
            int idx = getIdx(name, pic[i]);
            if (idx == -1) {
                continue;
            }
            //System.out.println(pic[i] + "의 점수 : " + yearning[idx]);
            score += yearning[idx];
        }
        
        return score;
    }
    
    public int getIdx(String[] name, String who) {
        for (int i = 0; i < name.length; i++) {
            if (name[i].equals(who)) {
                return i;
            }
        }
        
        return -1;
    }
}