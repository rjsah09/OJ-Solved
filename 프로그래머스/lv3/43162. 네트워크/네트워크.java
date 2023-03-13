class Solution {
    boolean[] visited;
    int[][] computers;
    
    public int solution(int n, int[][] computers) { //computers = adjMatrix
        int answer = 0;
        this.computers = computers;
        visited = new boolean[n];   //방문 정보가 저장된 
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                answer++;
                dfs(i);
            }
        }
        return answer;
    }
    
    public void dfs(int node) {
        visited[node] = true;
        
        for(int i = 0; i < visited.length; i++)
            if(!visited[i] && computers[node][i] == 1)
                dfs(i);
    }
}