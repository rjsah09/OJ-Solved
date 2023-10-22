import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    static int T;
    static int N;
    static ArrayList<String> mathematicalExpressionList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            mathematicalExpressionList = new ArrayList<>();
            N = Integer.parseInt(br.readLine());
            dfs(1, "1");

            Collections.sort(mathematicalExpressionList);
            for (int j = 0; j < mathematicalExpressionList.size(); j++) {
                sb.append(mathematicalExpressionList.get(j)).append("\n");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int depth, String expression) {
        if (depth == N) {
            int result = evaluate(expression);
            if (result == 0) {
                mathematicalExpressionList.add(expression);
            }
            return;
        }

        int nextDepth = depth + 1;
        dfs(nextDepth, expression + "+" + nextDepth);
        dfs(nextDepth, expression + "-" + nextDepth);
        dfs(nextDepth, expression + " " + nextDepth);
    }

    static int evaluate(String expression) {
        expression = expression.replaceAll(" ", "");
        String[] numberSplit = expression.split("[+,-]");
        int result = Integer.parseInt(numberSplit[0]);
        int numberIndex = 1;

        for (int i = 0; i < expression.length(); i++) {
            char operator = expression.charAt(i);

            if (operator == '+') {
                result += Integer.parseInt(numberSplit[numberIndex++]);
            } else if (operator == '-'){
                result -= Integer.parseInt(numberSplit[numberIndex++]);
            }
        }

        return result;
    }
}