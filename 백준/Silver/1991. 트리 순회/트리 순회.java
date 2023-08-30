import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    
    static int[][] adjMatrix;
    static boolean[] visited;
    static StringBuilder sb;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        adjMatrix = new int[N][2];
        for (int i = 0 ; i < N; i++) {
            for (int j= 0; j < 2; j++) {
              adjMatrix[i][j] = -1;
            }
        }

        //adjMatrix 생성
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node = st.nextToken().charAt(0) - 'A';
            int left, right;
            char leftCh = st.nextToken().charAt(0);
            if (leftCh != '.') {
                adjMatrix[node][0] = leftCh - 'A';
            }
            char rightCh = st.nextToken().charAt(0);
            if (rightCh != '.') {
                adjMatrix[node][1] = rightCh - 'A';
            }
        }
       
        sb = new StringBuilder();
        
        visited = new boolean[N];
        preorder(0);
        sb.append("\n");
        
        visited = new boolean[N];
        inorder(0);
        sb.append("\n");
        
        visited = new boolean[N];
        postorder(0);
        sb.append("\n");
        
        System.out.println(sb);
    }
    
    //전위순회
    static void preorder(int node) {
        visited[node] = true;
        char alp = (char)('A' + node);
        sb.append(alp);
        
        for (int i = 0; i < 2; i++) {
            int next = adjMatrix[node][i];
            if (next != -1 && !visited[next]) {
                preorder(next);
            }
        }
    }
    
    //중위 순회
    static void inorder(int node) {
        visited[node] = true;
        char alp = (char)('A' + node);
        
        int left = adjMatrix[node][0];
        if (left != -1 && !visited[left]) {
            inorder(left);
        }
        
        sb.append(alp);
        
        int right = adjMatrix[node][1];
        if (right != -1 && !visited[right]) {
            inorder(right);
        }
    }
    
    //후위 순회
    static void postorder(int node) {
        visited[node] = true;
        char alp = (char)('A' + node);
        
        int left = adjMatrix[node][0];
        if (left != -1 && !visited[left]) {
            postorder(left);
        }
        
        int right = adjMatrix[node][1];
        if (right != -1 && !visited[right]) {
            postorder(right);
        }
        
        sb.append(alp);
    }
    
}