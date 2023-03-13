import java.util.*;

class Solution {
    String [] words = new String[] {
        "aya",
        "ye",
        "woo",
        "ma"
    };
    
    public int solution(String[] babbling) {
        int answer = 0;
        
        for (int i = 0; i < babbling.length; i++) {
            if (isSpeakable(babbling[i])) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public boolean isSpeakable(String word) {
        String newWord = word + "";
        for (int i = 0; i < words.length; i++) {
            newWord = newWord.replace(words[i], "!");
        }
        
        for (int i = 0; i < newWord.length(); i++) {
            if (newWord.charAt(i) != '!') {
                return false;
            }
        }
        
        return true;
    }
}