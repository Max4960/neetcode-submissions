class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            int[] futures = Arrays.copyOfRange(prices, i+1, prices.length);
            for (int j = 0; j < futures.length; j++) {
                if (futures[j] - prices[i] > maxProfit) {
                    maxProfit = futures[j] - prices[i];
                }
            }
        }
        return maxProfit;
    }
}
