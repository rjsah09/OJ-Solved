class Solution {
    int count = 0;
    int answer = 0;
    String dict[] = {"A", "E", "I", "O", "U"};
    boolean found = false;
    
    public int solution(String word) {
        Boolean found = false;
        recursive("", word);
        return answer;
    }
    
    void recursive(String prev, String word) {
        for(int i = 0; i < 5; i++) {
            if(found) return;
            
            String now = prev + dict[i];
            count++;
            System.out.println(now);
            
            if(now.equals(word)) {
                answer = count;
                found = true;
                return;
            }
            
            if(now.length() >= 5) {
                if(now.charAt(4) == 'U')
                    return;
            } else {
                recursive(now, word);
            }
        }
    }
}