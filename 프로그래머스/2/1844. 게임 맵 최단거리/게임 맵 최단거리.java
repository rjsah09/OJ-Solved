import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        Queue<int[]> q = new LinkedList<>();
        int[] dx = new int[] {0, -1, 0, 1};
        int[] dy = new int[] {-1, 0, 1, 0};
        int rowLimit = maps.length;
        int colLimit = maps[0].length;
        
        q.add(new int[] {0, 0, 1});  //row, col depth
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int row = now[0];
            int col = now[1];
            int depth = now[2];
            
            if (maps[row][col] == 0) {
                continue;
            }
            maps[row][col] = 0;
            
            if (row == rowLimit - 1 &&  col == colLimit -1) {
                //answer = answer == -1 ? depth : Math.min(depth, answer);
                return depth;
            }
            
            for (int i = 0; i < 4; i++) {
                int nextRow = row + dx[i];
                int nextCol = col + dy[i];
                if (isIndexSafe(nextRow, nextCol, rowLimit, colLimit) 
                    && maps[nextRow][nextCol] == 1) {
                    q.add(new int[] {nextRow, nextCol, depth + 1});
                }
            }
        }
        
        return answer;
    }
    
    boolean isIndexSafe(int row, int col, int rowLimit, int colLimit) {
        return row >= 0 && row < rowLimit && col >= 0 && col < colLimit;
    }
}
