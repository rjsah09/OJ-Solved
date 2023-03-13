import java.util.Scanner;

public class Main {
    static int target;
    static int num;
    static String[] element;
    static int length;
    static int max = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        target = in.nextInt();
        num = in.nextInt();
        element = new String[num];
        length = Integer.toString(target).length();

        for (int i = 0; i < num; i++)
            element[i] = in.next();

        for(int i = 0; i < element.length; i++) {
            dfs(0, i, "");
        }

        System.out.println(max);
    }

    //res = 이전값
    static void dfs(int level, int node, String str) {
        str += element[node];

        int res = Integer.parseInt(str);
        if(target >= res && res > max)
            max = res;

        if(level == length - 1)
            return;


        for(int i = 0; i < num; i++) 
                dfs(level + 1, i, str);

    }
}