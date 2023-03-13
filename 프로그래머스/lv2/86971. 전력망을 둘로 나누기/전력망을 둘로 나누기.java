class Solution {
    boolean[] visited;  //탐색
    int[][] adj;
    
    public int solution(int n, int[][] wires) {
        int answer = n;
        
        for(int i = 0; i < wires.length; i++) { //i번째 와이어를 끊는 경우
            adj = new int[n][n];
            
            for(int j = 0; j < wires.length; j++) { //인접행렬 연결
                if(i != j) {
                    adj[wires[j][0] - 1][wires[j][1] - 1]++;
                    adj[wires[j][1] - 1][wires[j][0] - 1]++;
                }
            }
            
            visited = new boolean[n];
            int left = dfs(wires[i][0] - 1);
            
            visited = new boolean[n];
            int right = dfs(wires[i][1] - 1);
            
            if(answer > Math.abs(left - right))
                answer = Math.abs(left - right);
        }
        
        return answer;
    }
    
    int dfs(int node) {
        visited[node] = true;
        int nodes = 1;
        
        for(int i = 0; i < visited.length; i++) {
            if(visited[i] == false && adj[node][i] > 0)
                nodes += dfs(i);
        }
        
        return nodes;
    }
}