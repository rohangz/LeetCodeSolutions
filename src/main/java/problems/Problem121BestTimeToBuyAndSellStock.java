package problems;

public class Problem121BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int minBuy = prices[0];
        int maxProfit = 0;
        for (int i=1; i<prices.length;i++) {
            maxProfit = Math.max(maxProfit, prices[i]-minBuy);
            if (prices[i] < minBuy) {
                minBuy = prices[i];
            }

        }
        return maxProfit;
    }
}
