import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String word = br.readLine();
            //sb.append(word + " : " + isPalindrome(word)).append("\n");
            sb.append(isPalindrome(word, 0, word.length() - 1, false)).append("\n");
        }

        System.out.println(sb);
    }

    static int isPalindrome(String word, int preIndex, int postIndex, boolean flag) {
        int wrongLetterCount = 0;
        while (postIndex >= preIndex) {

            char pre = word.charAt(preIndex);
            char post = word.charAt(postIndex);
            char nextPre = word.charAt(preIndex + 1);
            char nextPost = word.charAt(postIndex - 1);

            //System.out.println("pre(" + preIndex + ")  : " + pre + ", post(" + postIndex + ") : " + post + ", count = " + wrongLetterCount);
            if (pre == post) {                                      //1. 양쪽이 맞는 경우
                preIndex++;
                postIndex--;
            } else {                                                //2. 양쪽이 맞지 않는 경우
                if (flag) {
                    return 2;
                }

                flag = true;
                if (pre == nextPost && nextPre == post) {           //2-1. 어느 쪽으로 해도 상관 없는 경우
                    return Math.min(isPalindrome(word, preIndex + 1, postIndex, true), isPalindrome(word, preIndex, postIndex - 1, true));
                } else if (nextPre == post) {                        //2-2. 왼쪽을 밀어야 하는 경우
                    //System.out.println(pre + " -> " + nextPre);
                    preIndex += 2;
                    postIndex--;
                } else if (pre == nextPost) {                       //2-3. 오른쪽을 당겨야 하는 경우
                    //System.out.println(post + " -> " + nextPost);
                    preIndex++;
                    postIndex -= 2;
                } else {                                            //2-4. 모두 맞지 않는 경우
                    return 2;
                }
            }
        }

        if (flag) {
            return 1;
        } else {
            return 0;
        }
    }
}
