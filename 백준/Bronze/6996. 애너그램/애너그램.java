import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static boolean solveAnagrams(String first, String second ) {
        String[] firstSplits = first.split("");
        String[] secondSplits = second.split("");
        
        Arrays.sort(firstSplits);
        Arrays.sort(secondSplits);

        if (Arrays.equals(firstSplits, secondSplits)) {
            return true;
        }
        return false;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTests = sc.nextInt();

        for (int i = 0; i < numTests; i++) {
            String first = sc.next().toLowerCase();
            String second = sc.next().toLowerCase();

            System.out.println(first + " & " + second + " are " + (solveAnagrams(first, second) ? "anagrams." : "NOT anagrams."));
        }
    }
}
