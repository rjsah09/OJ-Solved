import java.util.Scanner;

public class Main {
    static int input;
    static boolean[] visited;   //1부터 9까지
    static int[][] question;
    static int answer = 0; //정답 리스트

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        input = in.nextInt();
        question = new int[input][3];
        visited = new boolean[9];

        for(int i = 0; i < input; i++) {
            question[i][0] = in.nextInt();
            question[i][1] = in.nextInt();
            question[i][2] = in.nextInt();

        }

        for(int i = 0; i < 9; i++)
            dfs(0, i, "");

        System.out.println(answer);
    }

    //res = 이전 값
    static void dfs(int level, int node, String res) {
        visited[node] = true;
        res += Integer.toString(node + 1);
        level++;

        if(level == 3) {    //3인 경우
            visited[node] = false;
            prediction(res);
            return;
        }

        for(int i = 0; i < visited.length; i++) {
            if(!visited[i])
                dfs(level, i, res);
        }

        visited[node] = false;
    }

    static void prediction(String num) {
        for(int i = 0; i < input; i++) {    //각 종목에 대해
            String target = Integer.toString(question[i][0]);
            int strike = 0;
            int ball = 0;

            for(int j = 0; j < 3; j++) {    //스트라이크 체크
                if(num.charAt(j) == target.charAt(j)) {
                    strike++;
                }
            }

            for(int j = 0; j < 3; j++) {    //num의 각 자리에 대해
                for(int k = 0; k < 3; k++) {    //target의 각 자리와 비교
                    if(j != k && num.charAt(j) == target.charAt(k)) ball++;
                }
            }

            if(strike != question[i][1] || ball != question[i][2])
                return;
        }

        answer++;
    }
}
