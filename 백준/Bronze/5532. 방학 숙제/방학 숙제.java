import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());    //방학 일수
        int A = Integer.parseInt(br.readLine());    //국어 페이지 수
        int B = Integer.parseInt(br.readLine());    //수학 페이지 수
        int C = Integer.parseInt(br.readLine());    //하루에 풀 수 있는 국어 숙제 페이지 수
        int D = Integer.parseInt(br.readLine());    //하루에 풀 수 있는 수학 숙제 페이지 수

        int koreanSolvingDay = A % C == 0 ? A / C : A / C + 1;
        int mathSolvingDay = B % D == 0 ? B / D : B / D + 1;
        int leftDay = L - Math.max(koreanSolvingDay, mathSolvingDay);

        System.out.println(leftDay);
    }
}