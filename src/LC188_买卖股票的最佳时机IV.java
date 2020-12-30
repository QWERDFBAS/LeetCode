import org.junit.Test;

/**
 * 给定一个整数数组prices ，它的第 i 个元素prices[i] 是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例 1：
 * 输入：k = 2, prices = [2,4,1]
 * 输出：2
 * 解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 *
 * 示例 2：
 * 输入：k = 2, prices = [3,2,6,5,0,3]
 * 输出：7
 * 解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 *      随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3.
 */

public class LC188_买卖股票的最佳时机IV {

    @Test
    public void test() {
        int[] prices = {1, 2, 3, 4, 5};
        System.out.println(maxProfit(prices));
    }



    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if(k == 0 || len < 2) {
            return 0;
        }
        if(k >= len / 2) {
            return greed(prices, len);
        }

//        int[][][] dp = new int[len + 1][k + 1][2];
//
//        for(int i = 0; i <= len; i++) {
//            for(int j = 0; j <= k; j++) {
//                dp[i][j][1] = Integer.MIN_VALUE;
//            }
//        }
//
//        for(int i = 1; i <= len; i++) {
//            for(int j = 1; j <= k; j++) {
//                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] - prices[i]);
//                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] + prices[i]);
//            }
//        }

        int[][] dp = new int[k + 1][2];
        for(int i = 0; i <= k; i++) {
            dp[i][1] = Integer.MIN_VALUE;
        }
        for(int price : prices) {
            for(int i = 0; i <= k; i++) {
                dp[i][0] = Math.max(dp[i][0], dp[i][1] - price);
                dp[i][1] = Math.max(dp[i][1], dp[i - 1][0] + price);
            }
        }
        return dp[k][0];
    }

    public int greed(int[] prices, int len) {
        int res = 0;
        for(int i = 1; i < len; i++) {
            if(prices[i - 1] < prices[i]) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }

    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][][] dp = new int[len][3][2];
        dp[0][1][1] = -prices[0];
        dp[0][2][1] = Integer.MIN_VALUE;
        for (int i = 1; i < len; i++) {
            dp[i][1][0] = Math.max(dp[i - 1][1][1] + prices[i], dp[i - 1][1][0]);
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][0] - prices[i]);
            dp[i][2][0] = Math.max(dp[i - 1][2][1] + prices[i], dp[i - 1][2][0]);
            dp[i][2][1] = Math.max(dp[i - 1][1][0] - prices[i], dp[i - 1][2][1]);
        }
        return Math.max(dp[len - 1][2][0], dp[len - 1][1][0]);
    }
}
