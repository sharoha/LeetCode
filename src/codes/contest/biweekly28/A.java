package codes.contest.biweekly28;

import codes.fastio_java.InputReader;
import codes.fastio_java.OutputWriter;

public class A {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
    }

    public int[] finalPrices(int[] prices) {
        int[] finalPrice = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int discount = 0;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    discount = prices[j];
                    break;
                }
            }
            finalPrice[i] = prices[i] - discount;
        }
        return finalPrice;
    }
}
