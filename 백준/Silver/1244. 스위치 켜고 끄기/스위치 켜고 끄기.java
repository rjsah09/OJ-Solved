import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] switchStat;
    static int[][] studentStat;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int switches = Integer.parseInt(br.readLine());
        switchStat = new int[switches];
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        for(int i = 0; i < switches; i++)
            switchStat[i] = Integer.parseInt(st.nextToken());

        int students = Integer.parseInt(br.readLine());
        studentStat = new int[students][2];
        for(int i = 0; i < students; i++) {
            input = br.readLine();
            st = new StringTokenizer(input);
            studentStat[i][0] = Integer.parseInt(st.nextToken());
            studentStat[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < students; i++) {
            if(studentStat[i][0] == 1)
                boyProcessing(studentStat[i][1]);
            else
                girlProcessing(studentStat[i][1]);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < switches; i++) {
            if(i % 20 == 0 && i > 0)
                sb.append("\n");
            sb.append(switchStat[i] + " ");
        }
        System.out.println(sb);
    }

    static void boyProcessing(int switchNo) {
        for(int i = switchNo - 1; i < switchStat.length; i++) {
            if((i + 1) % switchNo == 0)
                switchStat[i] = (switchStat[i] + 1) % 2;
        }
    }

    static void girlProcessing(int switchNo) {
        int range = Math.min(switchNo - 1, switchStat.length - switchNo);

        switchStat[switchNo - 1] = (switchStat[switchNo - 1] + 1) % 2;
        for(int i = 1; i <= range; i++) {
            if(switchStat[switchNo - i - 1] != switchStat[switchNo + i - 1]) break;

            switchStat[switchNo - i - 1] = (switchStat[switchNo - i - 1] + 1) % 2;
            switchStat[switchNo + i - 1] = (switchStat[switchNo + i - 1] + 1) % 2;
        }
    }
}