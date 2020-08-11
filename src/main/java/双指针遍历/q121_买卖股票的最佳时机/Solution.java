package 双指针遍历.q121_买卖股票的最佳时机;

/**
 * @author fmk
 * @date 2020/8/9 20:42
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int currMaxProfit = 0;
        for (int i = 0, j = 0; j < prices.length; j++) {
            // 在历史最低点买进的
            if (prices[j] - prices[i] < 0) {
                i = j;
            } else {
                // 今天卖出能赚多少钱
                currMaxProfit = Math.max(prices[j] - prices[i], currMaxProfit);
            }
        }
        return currMaxProfit;
    }
}
