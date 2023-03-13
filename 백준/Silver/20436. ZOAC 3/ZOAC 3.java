import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String[][] leftHand = {{"q", "w", "e", "r", "t"},
            {"a", "s", "d", "f", "g"},
            {"z", "x", "c", "v", ""}};
    static String[][] rightHand = {{"", "y", "u", "i", "o", "p"},
            {"", "h", "j", "k", "l", ""},
            {"b", "n", "m", "", "", ""}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int[][] pos = {getPos(st.nextToken(), 0), getPos(st.nextToken(), 1)};
        str = br.readLine();
        int res = 0;

        for(int i = 0; i < str.length(); i++) {
            String tok = str.substring(i, i +1);
            if(isLeftHand(tok)) {
                int[] newPos = getPos(tok, 0);
                res += Math.abs(pos[0][0] - newPos[0]) + Math.abs(pos[0][1] - newPos[1]);
                pos[0][0] = newPos[0];
                pos[0][1] = newPos[1];
            } else {
                int[] newPos = getPos(tok, 1);
                res += Math.abs(pos[1][0] - newPos[0]) + Math.abs(pos[1][1] - newPos[1]);
                pos[1][0] = newPos[0];
                pos[1][1] = newPos[1];
            }
        }

        System.out.println(res + str.length());
    }

    static int[] getPos(String str, int hand) { //L:0, R:1
        int row = hand == 0 ? 5 : 6;

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < row; j++) {
                if(hand == 0 && str.equals(leftHand[i][j]))
                    return new int[] {i, j};
                else if(hand == 1 && str.equals(rightHand[i][j]))
                    return new int[] {i, j};
            }
        }

        return new int[] {-1, -1};
    }

    static boolean isLeftHand(String str) {
        for(int i = 0; i < leftHand.length; i++) {
            for(int j = 0; j < leftHand[0].length; j++) {
                if(str.equals(leftHand[i][j])) return true;
            }
        }

        return false;
    }
}