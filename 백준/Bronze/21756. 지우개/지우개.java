import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(i + 1);
        }

        while (list.size() > 1) {
            for (int i = 0; i < list.size(); i++) {
                if (i % 2 == 0) {
                    list.set(i, -1);
                }
            }

            ArrayList<Integer> newList = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) != -1) {
                    newList.add(list.get(i));
                }
            }

            list = newList;
        }

        System.out.println(list.get(0));
    }
}