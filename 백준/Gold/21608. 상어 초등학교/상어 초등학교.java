import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] favorites;
    static int[][] board;
    static int[] dx;
    static int[] dy;
    static int satisfaction;
    static Map<Integer, Integer> studentIndexMap;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        favorites = new int[N * N][5];
        board = new int[N][N];
        dx = new int[] {0, -1, 0, 1};
        dy = new int[] {-1, 0, 1, 0};
        satisfaction = 0;
        studentIndexMap = new HashMap<>();

        //favorites 채우기
        for (int i = 0; i < N * N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 5; j++) {
                int student = Integer.parseInt(st.nextToken());
                if (j == 0) {
                    studentIndexMap.put(student, i);
                }
                favorites[i][j] = student;
            }
        }

        for (int i = 0; i < favorites.length; i++) {
            setBestPosition(i);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int adjacentCount = getAdjacentFavoriteCount(studentIndexMap.get(board[i][j]), i, j);
                //System.out.println((i + 1) + ", " + (j + 1) + "의 위치에 " + board[i][j] + "학생이 착석, " + adjacentCount + "만큼의 친구가 있음");
                if (adjacentCount > 0) {
                    satisfaction += Math.pow(10, adjacentCount - 1);
                }
            }
        }

        System.out.println(satisfaction);
    }

    static void setBestPosition(int index) {
        int studentNo = favorites[index][0];
        int bestFavoriteCount = 0;  //가장 많은 단짝
        int bestEmptySpotCount = 0; //가장 많은 빈 공간

        //bestFavoriteCount, bestEmptySpotCount 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] != 0) {
                    continue;
                }

                int nowFavoriteCount = getAdjacentFavoriteCount(index, i, j);
                int nowEmptySpotCount = getEmptySpotCount(i, j);

                if (nowFavoriteCount > bestFavoriteCount) {
                    bestFavoriteCount = nowFavoriteCount;
                    bestEmptySpotCount = nowEmptySpotCount;
                } else if (nowFavoriteCount == bestFavoriteCount) {
                    bestEmptySpotCount = Math.max(nowEmptySpotCount, bestEmptySpotCount);
                }
            }
        }

        //System.out.println(studentNo + "번 째 학생의 bestFavorite = " + bestFavoriteCount + ", bestEmptySpotCount = " + bestEmptySpotCount);

        //규칙을 만족 하는 가장 우선의 인덱스에 저장
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (getAdjacentFavoriteCount(index, i, j) == bestFavoriteCount && getEmptySpotCount(i, j) == bestEmptySpotCount && board[i][j] == 0) {
                    board[i][j] = studentNo;
                    //System.out.println(studentNo + "번 째 학생을 [" + (i + 1) + ", " + (j + 1) + "]에 저장");
                    return;
                }
            }
        }
    }

    static int getAdjacentFavoriteCount(int index, int row, int col) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int adjRow = row + dx[i];
            int adjCol = col + dy[i];

            if (isIndexSafe(adjRow, adjCol)) {
                for (int j = 1; j < 5; j++) {
                    if (board[adjRow][adjCol] == favorites[index][j]) {
                        //System.out.println(board[adjRow][adjCol] + ", " + favorites[index][j]);
                        count++;
                        break;
                    }
                }
            }
        }

        return count;
    }

    static int getEmptySpotCount(int row, int col) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int adjRow = row + dx[i];
            int adjCol = col + dy[i];

            if (isIndexSafe(adjRow, adjCol) && board[adjRow][adjCol] == 0) {
                count++;
            }
        }

        return count;
    }

    static boolean isIndexSafe(int row, int col) {
        if (row < 0 || row >= N || col < 0 || col >= N) {
            return false;
        }

        return true;
    }

}