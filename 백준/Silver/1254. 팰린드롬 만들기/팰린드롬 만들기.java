import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//10:58 ~ 11:06
//1:59 ~ 2:03
//3:50 ~

//시작 지점을 찾는다
//시작 지점으로부터 끝까지 substring 후 뒤집어서 비교
//
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < str.length(); i++) {    //중간지점
            String subbed = str.substring(i);
            StringBuffer sb = new StringBuffer(subbed);
            String reversed = sb.reverse().toString();

            if (subbed.equals(reversed)) {
                min = Math.min(min, str.length() + i);
            }
        }

        System.out.println(min);
    }
}
