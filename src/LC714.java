import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组prices，其中第i个元素代表了第i天的股票价格 ；非负整数fee 代表了交易股票的手续费用。
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * 返回获得利润的最大值。
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 *
 * 示例 1:
 * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出: 8
 * 解释: 能够达到的最大利润:
 * 在此处买入prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润:((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 *
 * 注意:
 * 0 < prices.length <= 50000.
 * 0 < prices[i] < 50000.
 * 0 <= fee < 50000.
 */

public class LC714 {
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
//        0:当天买入， 1:当天卖出。
        int[][] dp = new int[len][2];
        dp[0][0] = -prices[0] - fee;
        for(int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] - prices[i] - fee, dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }

//        int sell = 0;
//        int buy = -prices[0] - fee;
//        for(int i = 1; i < len; i++) {
//            buy = Math.max(sell - prices[i] - fee, buy);
//            sell = Math.max(sell, buy + prices[i]);
//        }
//        return Math.max(buy, sell);


        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }

    public char findTheDifference(String s, String t) {
//        Map<Character, Integer> map = new HashMap<>();
//        int slen = s.length();
//        int tlen = t.length();
//
//        for(int i = 0; i < slen; i++) {
//            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
//        }
//
//        for(int i = 0; i < tlen; i++) {
//            if(map.containsKey(t.charAt(i)) && map.get(t.charAt(i)) > 0) {
//                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
//            } else {
//                return t.charAt(i);
//            }
//        }
//        return ' ';
        int sums = 0, sumt = 0;
        for(int i = 0; i < s.length(); i++) {
            sums += s.charAt(i);
        }
        for(int i = 0; i < t.length(); i++) {
            sumt += t.charAt(i);
        }
        return (char)(sumt - sums);
    }
}
