import java.util.*;

class Solution {
    
    boolean[] areNotPrime;
    boolean[] visited;
    String[] splits;
    Set<Integer> primeSet;
    
    public int solution(String numbers) {
        int answer = 0;
        makeBoard();
        primeSet = new HashSet<>();
        
        splits = numbers.split("");
        visited = new boolean[splits.length];
        
        for (int i = 0; i < numbers.length(); i++) {
            dfs(i, 1, "");
        }
        
        return primeSet.size();
    }
    
    void dfs(int node, int depth, String word) {
        visited[node] = true;
        word += splits[node];
        
        if (isPrime(Integer.parseInt(word))) {
            primeSet.add(Integer.parseInt(word));
        }
        
        if (depth < splits.length) {
            for (int i = 0; i < splits.length; i++) {
                if (!visited[i]) {
                    dfs(i, depth + 1, word);
                }
            }
        }
        
        
        
        visited[node] = false;
    }
    
    void makeBoard() {
        int size = 10000000;
        areNotPrime = new boolean[size];
        
        areNotPrime[0] = true;
        areNotPrime[1] = true;
        
        for (int i = 2; i < size; i++) {
            if (areNotPrime[i]) {
                continue;
            }
            
            for (int j = 2; i * j < size; j++) {
                areNotPrime[i * j] = true;
            }
        }
    }
    
    boolean isPrime(int n) {
        return !areNotPrime[n];
    }
    
    
    
}