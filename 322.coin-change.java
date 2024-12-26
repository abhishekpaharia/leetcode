/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 */

// @lc code=start

import java.util.Arrays;

class Solution{
    // // my method 1.1 : amount loop out, coins loop inside 
    // public int coinChange(int[] coins, int amount) {
    //     int n = coins.length;
    //     if(n <= 0){
    //         return 0;
    //     }

    //     int[] dp = new int[amount+1];
    //     for(int a = 1; a<amount+1; a++){
    //         int min = Integer.MAX_VALUE;
    //         for(int j =0; j<n; j++){
    //             int x = 0;
    //             if(a - coins[j] < 0){
    //                 x = Integer.MAX_VALUE;
    //             } else {
    //                 if(dp[a - coins[j]] == Integer.MAX_VALUE){
    //                     x = Integer.MAX_VALUE;
    //                 } else {
    //                     x = dp[a - coins[j]] + 1;
    //                 }
    //             }
    //             min = Math.min(min, x);
    //         }
    //         dp[a] = min;
    //     }
    //     if(dp[amount] == Integer.MAX_VALUE){
    //         return -1;
    //     }
    //     return dp[amount];
    // }

    //method 1.2: amount loop out, coins loop inside. same algo but how to avoid Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        if(n <= 0){
            return 0;
        }

        int[] dp = new int[amount+1];
        int max_coins = amount + 1;
        Arrays.fill(dp, max_coins);
        dp[0] = 0;
        for(int a = 1; a<amount+1; a++){
            for(int j =0; j<n; j++){
                if(a - coins[j] >= 0){
                    dp[a] = Math.min(dp[a],dp[a - coins[j]] + 1);
                }
            }
        }
        System.out.println(dp[amount]);
        if(dp[amount] >= max_coins){
            return -1;
        }
        return dp[amount];
    }

    // Method 2.1 : coins loop out, amount loop inside. it works 
    // public int coinChange(int[] coins, int amount) {
    //     int n = coins.length;
    //     if(n <= 0){
    //         return 0;
    //     }

    //     //dp[i][sum] gives min number coins needed of all possible unique combination whose sum is "sum" using first i elements in coins array or first i types of coins. combination can have any coins[j] where j < i and with frequency [0, infinity] as long as sum >= 0. dp[i][sum] gets it meaning because of the intial / base condition and recurrence for formula
    //     int[][] dp = new int[n+1][amount+1];
    //     int max_coins = amount + 1;

    //      // base condition : dp[i][0] = 0 and dp[0][sum]  = infinity, not possible (Integer.MAX_VALUE), sum is not 0.
    //     // Integer.MAX_VALUE means not possible
    //     Arrays.fill(dp[0], Integer.MAX_VALUE);
    //     dp[0][0] = 0;
        
    //     for(int i = 1; i< n+1; i++){
    //         for(int sum = 1; sum < amount + 1; sum++){
    //             dp[i][sum] = dp[i-1][sum];
    //             if(sum - coins[i-1] >= 0){
    //                 if(dp[i][sum - coins[i-1]] != Integer.MAX_VALUE){
    //                     dp[i][sum] = Math.min(dp[i][sum], dp[i][sum - coins[i-1]] + 1);
    //                 }
    //             }
    //         }
    //     }
    //     System.out.println(dp[n][amount]);

    //     return dp[n][amount] == Integer.MAX_VALUE ? -1 : dp[n][amount];
    // }

    //Method 2.2 : coins loop out, amount loop inside. it works
    // public int coinChange(int[] coins, int amount) {
    //     int n = coins.length;
    //     if(n <= 0){
    //         return 0;
    //     }

    //     int[] dp = new int[amount+1];
    //     // Integer.MAX_VALUE means not possible
    //     Arrays.fill(dp, Integer.MAX_VALUE);
    //     dp[0] = 0;
        
    //     for(int i = 1; i< n+1; i++){
    //         for(int sum = 1; sum < amount + 1; sum++){
    //             if(sum - coins[i-1] >= 0){
    //                 if(dp[sum - coins[i-1]] != Integer.MAX_VALUE){
    //                     dp[sum] = Math.min(dp[sum], dp[sum - coins[i-1]] + 1);
    //                 }
    //             }
    //         }
    //     }
    //     System.out.println(dp[amount]);

    //     return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    // }



    // Do not work . method 2.3 : coins loop out, amount loop inside. wrong space optimisation
    // do not work because  
    // dp[sum] = Math.min(dp[sum], dp[sum - coins[i-1]] + 1);
    // on right side of qual to, dp[sum] represents dp[i-1][sum], which we need, but
    // dp[sum - coins[i-1]] represents dp[i-1][sum - coins[i-1]] but we need dp[i][sum - coins[i-1]]

    
    // public int coinChange(int[] coins, int amount) {
    //     int n = coins.length;
    //     if(n <= 0){
    //         return 0;
    //     }

    //     int[] dp = new int[amount+1];
    //     // Integer.MAX_VALUE means not possible
    //     Arrays.fill(dp, Integer.MAX_VALUE);
    //     dp[0] = 0;
        
    //     for(int i = 1; i< n+1; i++){
    //         for(int sum = amount; sum >= 1; sum--){
    //             //dp[sum] = dp[sum];
    //             if(sum - coins[i-1] >= 0){
    //                 if(dp[sum - coins[i-1]] != Integer.MAX_VALUE){
    //                     dp[sum] = Math.min(dp[sum], dp[sum - coins[i-1]] + 1);
    //                 }
    //             }
    //         }
    //     }
    //     System.out.println(dp[amount]);

    //     return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    // }
}
// @lc code=end

