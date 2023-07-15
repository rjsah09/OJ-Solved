import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("push")) {
                int value = Integer.parseInt(st.nextToken());
                stack.push(value);
            } else if (command.equals("pop")) {
                if (stack.isEmpty()) {
                    sb.append(-1 + "\n");
                } else {
                    sb.append(stack.pop() + "\n");
                }
            } else if (command.equals("size")) {
                sb.append(stack.size() + "\n");
            } else if (command.equals("empty")) {
                if (stack.isEmpty()) {
                    sb.append(1 + "\n");
                } else {
                    sb.append(0 + "\n");
                }
            } else if (command.equals("top")) {
                if (stack.isEmpty()) {
                    sb.append("-1" + "\n");
                } else {
                    sb.append(stack.peek() + "\n");
                }
            }
        }

        System.out.println(sb);
    }
}
