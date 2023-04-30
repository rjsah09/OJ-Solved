import java.util.StringTokenizer;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        boolean[][] map = new boolean[park.length][park[0].length()];
        
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[0].length(); j++) {
                String str = park[i].substring(j, j + 1);
                if (str.equals("O")) {
                    map[i][j] = true;
                } else if (str.equals("X")) {
                    map[i][j] = false;
                } else if (str.equals("S")) {
                    map[i][j] = true;
                    answer = new int[] {i, j};
                }
            }
        }
        
        for (int i = 0; i < routes.length; i++) {
            StringTokenizer st =  new StringTokenizer(routes[i]);
            int[] vector = getVector(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            
            if (isMovable(map, answer, vector, dist)) {
                answer = new int[] {answer[0] + vector[0] * dist, answer[1] + vector[1] * dist};
            }
            
        }
        
        return answer;
    }
    
    public int[] getVector(String dir) {
        switch (dir) {
            case "E" :
                return new int[] {0, 1};
            case "W" :
                return new int[] {0, -1};
            case "N" :
                return new int[] {-1, 0};
            case "S" :
                return new int[] {1, 0};
        }
        
        return new int[] {0, 0};
    }
    
    public boolean isMovable(boolean[][] map, int[] position, int[] vector, int dist) {
        for (int i = 1; i <= dist; i++) {
                int[] newPos = {position[0] + vector[0] * i, position[1] + vector[1] * i};
                if (newPos[0] < 0 || newPos[1] < 0 || newPos[0] >= map.length || newPos[1] >= map[0].length) {
                    return false;
                } else if (!map[newPos[0]][newPos[1]]) {
                    return false;
                }
        }
        
        return true;
    }
    
}