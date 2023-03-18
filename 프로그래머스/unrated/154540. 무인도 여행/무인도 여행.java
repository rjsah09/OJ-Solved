import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(String[] maps) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (maps[i].charAt(j) != 'X') {
                    list.add(dfs(maps, i, j));
                }
            }
        }
        
        if (list.size() == 0) {
            return new int[] {-1};
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);      
        }
        
        Arrays.sort(answer);
        return answer;
    }
    
    public int dfs(String[] maps, int posI, int posJ) {
        int value = Integer.parseInt(maps[posI].substring(posJ, posJ + 1));
        String newString =  maps[posI].substring(0, posJ) + "X" + maps[posI].substring(posJ + 1, maps[0].length());
        maps[posI] = newString;
        
        //좌우
        for (int i = -1; i <= 1; i++) {
            if (posJ + i >= 0 && posJ + i < maps[0].length()) {
                if (maps[posI].charAt(posJ + i) != 'X') {
                    value += dfs(maps, posI, posJ + i);
                }
            }
        }
        
        //상하
        for (int i = -1; i <= 1; i++) {
            if (posI + i >= 0 && posI + i < maps.length) {
                if (maps[posI + i].charAt(posJ) != 'X') {
                    value += dfs(maps, posI + i, posJ);
                }
            }
        }
        
        return value;
    }
}