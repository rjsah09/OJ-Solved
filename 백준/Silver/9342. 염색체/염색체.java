import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

public class Main {

    static Set<Character> firstLetterSet;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        firstLetterSet = Set.of('A', 'B', 'C', 'D', 'E', 'F');

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String genome = br.readLine();
            String result = isInfectedWithStartA(genome) || isInfected(genome, 0) ? "Infected!" : "Good";
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    static boolean isInfectedWithStartA(String genome) {
        if (genome.charAt(0) < 'A' || genome.charAt(0) > 'F') {
            return false;
        }

        return isInfected(genome, 1);
    }

    static boolean isInfected(String genome, int startIndex) {
        if (genome.length() < 2) {
            return false;
        }
        
        //A
        int index = getLastLetterIndex(genome, startIndex, 'A');
        //System.out.println("A의 마지막 인덱스 : " + index);
        if (index == -1 || index == genome.length()) {
            return false;
        }

        //F
        index = getLastLetterIndex(genome, index + 1, 'F');
        //System.out.println("F의 마지막 인덱스 : " + index);
        if (index == -1 || index == genome.length()) {
            return false;
        }

        //C
        index = getLastLetterIndex(genome, index + 1, 'C');
        //System.out.println("C의 마지막 인덱스 : " + index);
        if (index == -1) {
            return false;
        }

        if (index == genome.length()) { //현재 인덱스가 마지막
            //System.out.println("글자 안남음");
            return true;
        } else if (index + 1 == genome.length() - 1) {  //다음 인덱스가 마지막
            //System.out.println("마지막 한글자 남음");
            return genome.charAt(index + 1) >= 'A' && genome.charAt(index + 1) <= 'F';
        } else {
            //System.out.println("글자 너무 많이 남음");
            return false;
        }
    }

    static int getLastLetterIndex(String genome, int searchIndex, char letter) {
        //처음부터 글자가 없는 경우 -1 리턴
        if (genome.charAt(searchIndex) != letter) {
            return -1;
        }

        //마지막 letter와 같았던 위치를 리턴
        for (int i = searchIndex + 1; i < genome.length(); i++) {
            if (genome.charAt(i) != letter) {
                return i - 1;
            }
        }

        //모두 letter와 같다면 글자의 길이를 리턴
        return genome.length();
    }

}
