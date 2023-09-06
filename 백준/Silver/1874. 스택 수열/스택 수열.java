import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static StringBuilder sb;
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        stack = new Stack<>();
        int haveToPush = 1;
        sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int sequenceNum = Integer.parseInt(br.readLine());

            if (haveToPush <= sequenceNum) {
                for (int j = haveToPush; j <= sequenceNum; j++) {
                    push(j);
                    haveToPush++;
                }

                pop();
            } else {
                if (!stack.isEmpty() && stack.peek() == sequenceNum) {
                    pop();
                } else {
                    System.out.println("NO");
                    return;
                }
            }
        }

        System.out.println(sb);
    }

    static void push(int n) {
        stack.push(n);
        sb.append("+").append("\n");
    }

    static void pop() {
        stack.pop();
        sb.append("-").append("\n");
    }
}
