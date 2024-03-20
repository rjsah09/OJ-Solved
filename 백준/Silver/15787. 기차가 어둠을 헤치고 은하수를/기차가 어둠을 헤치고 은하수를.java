import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<Boolean>[] seatLists;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        seatLists = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            seatLists[i] = new ArrayList<>();
            for (int j = 0; j < 20; j++) {
                seatLists[i].add(false);
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            switch(command) {
                case 1:
                    command1(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
                    break;
                case 2:
                    command2(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
                    break;
                case 3:
                    command3(Integer.parseInt(st.nextToken()) - 1);
                    break;
                case 4:
                    command4(Integer.parseInt(st.nextToken()) - 1);
                    break;
            }
        }

        Set<ArrayList<Boolean>> trainSet = new HashSet<>(Arrays.asList(seatLists));
        System.out.println(trainSet.size());
    }

    static void command1(int train, int seat) {
        seatLists[train].set(seat, true);
    }

    static void command2(int train, int seat) {
        seatLists[train].set(seat, false);
    }

    static void command3(int train) {
        seatLists[train].add(0, false);
        seatLists[train].remove(20);
    }

    static void command4(int train) {
        seatLists[train].add(20, false);
        seatLists[train].remove(0);
    }
}
