// Problem Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-v/
class Solution {
    public Long dp[][][];
    public long maximumProfit(int[] prices, int k) {
        dp = new Long[prices.length+1][3][k+1];

        return solve(prices, 0, 0, k);
    }

    public long solve(int[] prices, int i, int t, int k) {
        int n = prices.length;
        if(i>=n) {
            if(t!=0) {
                // you are within a transaction;
                return Integer.MIN_VALUE;
            }

            return 0;
        }

        if(k == 0) return 0;

        if(dp[i][t][k]!=null) return dp[i][t][k];

        long op1 = Integer.MIN_VALUE;
        long op2 = Integer.MIN_VALUE;
        long op3 = Integer.MIN_VALUE;
        if(t == 0) {
            // can start a transaction;
            op1 = -prices[i] + solve(prices, i+1, 1, k);
            op2 = prices[i] + solve(prices, i+1, 2, k);
        } else if(t == 1) {
            op1 = prices[i] + solve(prices, i+1, 0, k-1);
        } else if(t == 2) {
            op2 = -prices[i] + solve(prices, i+1, 0, k-1);
        }
        op3 = solve(prices, i+1, t, k);

        return dp[i][t][k] = Math.max(op1, Math.max(op2, op3));
    }
}
