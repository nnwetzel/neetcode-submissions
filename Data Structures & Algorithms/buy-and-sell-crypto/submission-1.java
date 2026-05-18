class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int p : prices) {
            if (p < minPrice) {
                minPrice = p;
            }
            else if (p - minPrice > maxProfit) {
                maxProfit = p - minPrice;
            }
        }
        return maxProfit;
    }
}
