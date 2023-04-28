import java.util.Map;
import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> nameNscore = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            nameNscore.put(players[i], i);
        }
        
        for (String call: callings) {
            int callIdx = nameNscore.get(call);
            int frontIdx = callIdx - 1;
            
            swap(players, nameNscore, callIdx, frontIdx);
        }
        
        return players;
    }
    
    void swap(String[] players, Map<String, Integer> nameNscore, int idx1, int idx2) {
        String tmp = players[idx1];
        players[idx1] = players[idx2];
        players[idx2] = tmp;
        
        nameNscore.put(players[idx1], idx1);
        nameNscore.put(players[idx2], idx2);
    }
}