import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] angles = new int[3];
        for (int i = 0; i < 3; i++) {
            angles[i] = Integer.parseInt(br.readLine());
        }

        int totalAngle = Arrays.stream(angles).sum();

        if (totalAngle == 180) {
            if (isEquilateral(angles)) {
                System.out.println("Equilateral");
            } else if (isIsosceles(angles)) {
                System.out.println("Isosceles");
            } else {
                System.out.println("Scalene");
            }
        } else {
            System.out.println("Error");
        }
    }

    static boolean isEquilateral(int[] angles) {
        return angles[0] == angles[1] && angles[1] == angles[2];
    }

    static boolean isIsosceles(int[] angles) {
        return angles[0] == angles[1] || angles[1] == angles[2] || angles[0] == angles[2];
    }
}
