import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int seed = Integer.parseInt(br.readLine());
        int[] stockPrices = new int[14];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < stockPrices.length; i++) {
            stockPrices[i] = Integer.parseInt(st.nextToken());
        }

        int bnpResult = getBNP(stockPrices, seed);
        int timingResult = getTiming(stockPrices, seed);

        if (bnpResult > timingResult) {
            System.out.println("BNP");
        } else if (bnpResult < timingResult) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }
    }

    static int getBNP (int[] stockPrices, int seed) {
        int stocks = 0;
        for (int i = 0; i < stockPrices.length; i++) {
            int purchasable = seed / stockPrices[i];
            stocks += purchasable;
            seed -= purchasable * stockPrices[i];
        }

        return stocks * stockPrices[13]+ seed;
    }

    static int getTiming(int[] stockPrices, int seed) {
        int stocks = 0;

        int upped = 0;
        int downed = 0;
        for (int i = 1; i < stockPrices.length; i++) {

            if (stockPrices[i] > stockPrices[i - 1]) {  //상승
                if (downed > 0) {   //하락중이었던 경우
                    upped =  1;
                    downed = 0;
                    continue;
                }

                upped++;
                if (upped == 3) {
                    seed += stocks * stockPrices[i];
                    stocks = 0;
                }
            } else if (stockPrices[i] < stockPrices[i - 1]) {   //하락
                if (upped > 0) {
                    upped = 0;
                    downed = 1;
                    continue;
                }

                downed++;
                if (downed >= 3) {
                    int purchasable = seed / stockPrices[i];
                    stocks += purchasable;
                    seed -= purchasable * stockPrices[i];
                }
            }
        }

        return stocks * stockPrices[13]+ seed;
    }

}
