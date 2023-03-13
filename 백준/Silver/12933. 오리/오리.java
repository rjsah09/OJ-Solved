import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        ArrayList<Integer> list = new ArrayList<>();

        if(input.length() % 5 != 0 || input.charAt(0) != 'q' || input.charAt(input.length() - 1) != 'k') {
            System.out.println(-1);
            return;
        }

        list.add(0);

        int i = 1;
        while(i < input.length()) {
            char ch = input.charAt(i);

            int target = -1;
            for(int j = 0; j < list.size(); j++) {
                if((list.get(j) + 1) % 5 == getNum(ch)) {
                    target = j;
                    list.set(j, (list.get(j) + 1) % 5);
                    break;
                }
            }

            if(target == -1 && ch == 'q') {
                list.add(0);
            } else if(target == -1) {
                System.out.println(target);
                return;
            }

            i++;
        }

        if(list.size() == 0) {
            System.out.println(-1);
            return;
        }

        System.out.println(list.size());
    }

    static int getNum(char ch) {
        switch(ch) {
            case 'q':
                return 0;
            case 'u':
                return 1;
            case 'a':
                return 2;
            case 'c':
                return 3;
            case 'k':
                return 4;
            default:
                return -1;
        }
    }
}