class Solution {
    public int maxProfit(int[] prices) {
        int i = 0 , j = 1;
        int profit = 0;
        while(j < prices.length) {
            int currProfit = prices[j] - prices[i];
            if(currProfit < 0) {
                i = j;
                j++;
                continue;
            }
            profit = Math.max(currProfit, profit);
            j++;
        }
        return profit;
    }
}
