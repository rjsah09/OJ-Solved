import java.util.Scanner;

public class Main {
    static int[][] board;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        board = new int[19][19];

        for(int i = 0; i < 19; i++) //1:오른위, 2:오른쪽, 3:오른아래, 4:아래쪽
            for(int j = 0; j < 19; j++)
                board[i][j] = in.nextInt();

        for(int i = 0; i < 19; i++) {   //y좌표
            for(int j = 0; j < 19; j++) {   //x좌표
                int clr = board[i][j];
                if(clr != 0) {  //돌이 놓여져 있다면
                    int dir = 0;
                    for(int k = 1; k <= 4; k++) {   //방향별로
                        if(isFive(i, j, k, clr)) {
                            System.out.println(clr);
                            System.out.println((i + 1) + " " + (j + 1));
                            return;
                        }
                    }
                }
            }
        }

        System.out.println(0);
    }

    static boolean isFive(int posI, int posJ, int dir, int clr) {
        if(!outChecker(posI, posJ, dir, clr)) return false;

        for(int i = 1; i <= 4; i++) {
            if(dir == 1) {
                if(posI - i >= 0 && posJ + i < 19) {
                    if (board[posI - i][posJ + i] == clr) continue;
                }
                return false;
            } else if(dir == 2) {
                if(posJ + i < 19) {
                    if (board[posI][posJ + i] == clr) continue;
                }
                return false;
            } else if(dir == 3) {
                if(posI + i < 19 && posJ + i < 19) {
                    if (board[posI + i][posJ + i] == clr) continue;
                }
                return false;
            } else {
                if(posI + i < 19) {
                    if (board[posI + i][posJ] == clr) continue;
                }
                return false;
            }
        }
        return true;
    }

    static boolean outChecker(int posI, int posJ, int dir, int clr) {   //true : 5줄을 놓으면 오목 / false : 다섯줄을 놓아도 오목X
        if(dir == 1) {
            if((posI + 1 >= 19 || posJ - 1 < 0) && (posI - 5 < 0 || posJ + 5 >= 19)) {
                return true;
            } else if(posI + 1 >= 19 || posJ - 1 < 0) {
                if (board[posI - 5][posJ + 5] != clr)
                    return true;
            } else if(posI - 5 < 0 || posJ + 5 >= 19) {
                if(board[posI + 1][posJ -1] != clr)
                    return true;
            } else {
                if(board[posI + 1][posJ - 1] != clr && board[posI - 5][posJ + 5] != clr)
                    return true;
            }
        } else if(dir == 2) {
            if(posJ - 1 < 0 && posJ + 5 >= 19) {
                return true;
            } else if(posJ -1 < 0) {
                if (board[posI][posJ + 5] != clr)
                    return true;
            } else if(posJ + 5 >= 19) {
                if(board[posI][posJ -1] != clr)
                    return true;
            } else {
                if(board[posI][posJ - 1] != clr && board[posI][posJ + 5] != clr)
                    return true;
            }
        } else if(dir == 3) {
            if((posI - 1 < 0 || posJ - 1 < 0) && (posI + 5 >= 19 || posJ + 5 >= 19)) {
                return true;
            } else if(posI - 1 < 0 || posJ - 1 < 0) {
                if (board[posI + 5][posJ + 5] != clr)
                    return true;
            } else if(posI + 5 >= 19 || posJ + 5 >= 19) {
                if(board[posI - 1][posJ - 1] != clr)
                    return true;
            } else {
                if(board[posI - 1][posJ - 1] != clr && board[posI + 5][posJ + 5] != clr)
                    return true;
            }
        } else if(dir == 4) {
            if(posI - 1 < 0 && posI + 5 >= 19) {
                return true;
            } else if(posI -1 < 0) {
                if (board[posI + 5][posJ] != clr) {
                    return true;
                }
            } else if(posI + 5 >= 19) {
                if(board[posI - 1][posJ] != clr) {
                    return true;
                }
            } else {
                if(board[posI - 1][posJ] != clr && board[posI + 5][posJ] != clr) {
                    return true;
                }
            }
        }
        return false;
    }
}
