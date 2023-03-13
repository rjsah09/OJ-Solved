import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        int size = phone_book.length;
        
        HashMap <String, Integer> map = new HashMap();
        
        for(int i = 0; i < size; i++){
            map.put(phone_book[i], i);
        }
        
        for(int i = 0; i < size; i++){
            for(int j = 1; j < phone_book[i].length(); j++) {
                if(map.containsKey(phone_book[i].substring(0, j)))
                    return false;
            }                
        }
        
        return true;
    }
}