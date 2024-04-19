class Solution {
    
    int[][] dungeons;
    boolean[] visited;
    int max;
    
    public int solution(int k, int[][] dungeons) {
        int answer = 0;
        
        this.dungeons = dungeons;
        visited = new boolean[dungeons.length];
        max = 0;
        
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                dfs(i, k, 1);
            }
        }
        
        return max;
    }
    
    void dfs(int node, int k, int depth) {
        visited[node] = true;
        k -= dungeons[node][1];
        max = Math.max(depth, max);
        
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                dfs(i, k, depth + 1);
            }
        }
        
        visited[node] = false;
    }
}