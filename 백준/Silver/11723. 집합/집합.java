import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Set<Integer> set;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        set = new HashSet<>();
        sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (st.hasMoreTokens()) {
                int value = Integer.parseInt(st.nextToken());
                doCommand(command, value);
            } else {
                doCommand(command, -1);
            }
        }

        System.out.println(sb);
    }

    static void doCommand(String command, int value) {
        switch (command) {
            case "add":
                add(value);
                break;
            case "remove":
                remove(value);
                break;
            case "check":
                check(value);
                break;
            case "toggle":
                toggle(value);
                break;
            case "all":
                all();
                break;
            case "empty":
                empty();
                break;
        }
    }

    static void add(int value) {
        set.add(value);
    }

    static void remove(int value) {
        set.remove(value);
    }

    static void check(int value) {
        int result = set.contains(value) ? 1: 0;
        sb.append(result).append("\n");
    }

    static void toggle(int value) {
        if (set.contains(value)) {
            set.remove(value);
        } else {
            set.add(value);
        }
    }

    static void all() {
        set.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
    }

    static void empty() {
        set.clear();
    }

}
