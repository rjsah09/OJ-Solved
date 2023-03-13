import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String input;
    static String[] word;
    static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        word = new String[input.length()];
        used = new boolean[input.length()];

        for(int i = 0; i < word.length; i++)
            word[i] = input.substring(i, i + 1);

        for(int i = 1; i < word.length; i++) {
            System.out.println(getFrontWord(i));
        }
        System.out.println(input);
    }

    public static String getFrontWord(int len) {
        String min = input;
        int idx = 0;

        for(int i = 0; i < word.length; i++) {
            String str = "";

            for(int j = 0; j < word.length; j++) {
                if(used[j]) str += word[j];
                else if(i == j) {
                    str += word[j];
                }
            }

            if(str.compareTo(min) < 0 && str.length() == len) {
                idx = i;
                min = str;
            }
        }

        used[idx] = true;
        return min;
    }
}