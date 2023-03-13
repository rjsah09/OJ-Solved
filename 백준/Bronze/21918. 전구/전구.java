import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] bulbStatus;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int bulbs = Integer.parseInt(st.nextToken());
        int commands = Integer.parseInt(st.nextToken());

        line = br.readLine();
        st = new StringTokenizer(line);
        bulbStatus = new int[bulbs];
        for(int i = 0; i < bulbs; i++)
            bulbStatus[i] = Integer.parseInt(st.nextToken());

        for(int i = 0; i <commands; i++) {
            line = br.readLine();
            st = new StringTokenizer(line);
            int[] command = new int[3];
            for(int j = 0; j < 3; j++)
                command[j] = Integer.parseInt(st.nextToken());

            switch(command[0]) {
                case 1:
                    command1(command[1], command[2]);
                    break;
                case 2:
                    command2(command[1], command[2]);
                    break;
                case 3:
                    command3(command[1], command[2]);
                    break;
                case 4:
                    command4(command[1], command[2]);
                    break;
            }
        }

        for(int num : bulbStatus) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    static void command1(int n1, int n2) {
        bulbStatus[n1 - 1] = n2;
    }

    static void command2(int n1, int n2) {
        for(int i = n1 - 1; i < n2; i++)
            if(bulbStatus[i] == 0)
                bulbStatus[i] = 1;
            else
                bulbStatus[i] = 0;
    }

    static void command3(int n1, int n2) {
        for(int i = n1 - 1; i < n2; i++)
            bulbStatus[i] = 0;
    }

    static void command4(int n1, int n2) {
        for(int i = n1 - 1; i < n2; i++)
            bulbStatus[i] = 1;
    }
}