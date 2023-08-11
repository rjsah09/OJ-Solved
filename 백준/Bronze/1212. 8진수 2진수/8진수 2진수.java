import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String octalString = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < octalString.length(); i++) {
            String binaryPiece = Integer.toBinaryString(octalString.charAt(i) - '0');
            if (i > 0 && binaryPiece.length() == 1) {
                binaryPiece = "00" + binaryPiece;
            } else if (i > 0 && binaryPiece.length() == 2) {
                binaryPiece = "0" + binaryPiece;
            }

            sb.append(binaryPiece);
        }

        System.out.println(sb);
    }
}