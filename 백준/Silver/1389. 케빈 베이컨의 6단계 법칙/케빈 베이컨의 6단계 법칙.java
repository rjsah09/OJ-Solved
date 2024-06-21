import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(matrix[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int one = Integer.parseInt(st.nextToken()) - 1;
            int other = Integer.parseInt(st.nextToken()) - 1;

            matrix[one][other] = 1;
            matrix[other][one] = 1;
        }

        for (int k = 0; k < N; k++) {  //k번째 노드를 경유하는 경우
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (matrix[i][k] != Integer.MAX_VALUE && matrix[k][j] != Integer.MAX_VALUE) {
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                        matrix[j][i] = Math.min(matrix[j][i], matrix[j][k] + matrix[k][i]);
                    }
                }
            }
        }

        int minRelation = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int relation: matrix[i]) {
                if (relation != Integer.MAX_VALUE) {
                    sum += relation;
                }
            }

            //System.out.println((i + 1) + "번째 = " + sum);
            if (minRelation > sum) {
                minRelation = sum;
                minIndex = i;
            }
        }

        System.out.println(minIndex + 1);
    }
}