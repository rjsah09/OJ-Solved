import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] nutrientsCutOff;
    static int[][] nutrientsBoard;
    static boolean[] visited;
    static ArrayList<Integer> selectedList;
    static int minimumCost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nutrientsCutOff = new int[4];
        nutrientsBoard = new int[N][5];
        visited = new boolean[N];
        selectedList = new ArrayList<>();
        minimumCost = -1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            nutrientsCutOff[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                nutrientsBoard[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            visited[i] = true;
            dfs(i, nutrientsBoard[i][0], nutrientsBoard[i][1], nutrientsBoard[i][2], nutrientsBoard[i][3], nutrientsBoard[i][4]);
            visited[i] = false;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(minimumCost).append("\n");
        if (minimumCost != -1) {
            for (int i = 0; i < selectedList.size(); i++) {
                sb.append(selectedList.get(i) + " ");
            }
        }

        System.out.println(sb);
    }

    static void dfs(int foodIndex, int protein, int fat, int carbohydrate, int vitamin, int cost) {
        if (meetTheCriteria(protein, fat, carbohydrate, vitamin)) {
            if (minimumCost == -1 || minimumCost > cost) {
                minimumCost = cost;
                selectedList = getSelectedList();
            }

            return;
        }

        if (minimumCost != -1 && cost > minimumCost) {
            return;
        }

        for (int i = foodIndex + 1; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, protein + nutrientsBoard[i][0]
                        , fat + nutrientsBoard[i][1]
                        , carbohydrate + nutrientsBoard[i][2]
                        , vitamin + nutrientsBoard[i][3]
                        , cost + nutrientsBoard[i][4]
                );
                visited[i] = false;
            }
        }
    }

    static boolean meetTheCriteria(int protein, int fat, int carbohydrate, int vitamin) {
        if (protein < nutrientsCutOff[0] || fat < nutrientsCutOff[1] || carbohydrate < nutrientsCutOff[2] || vitamin < nutrientsCutOff[3]) {
            return false;
        }

        return true;
    }

    static ArrayList<Integer> getSelectedList() {
        ArrayList<Integer> selectedList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                selectedList.add(i + 1);
            }
        }

        return selectedList;
    }

}