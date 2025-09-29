import java.util.*;
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = amount+1;
        int[] dp = new int[n];

        Arrays.fill(dp,n);
        dp[0]=0;

        for(int i=1;i<=amount;i++){
            for(int coin: coins){
                if(i-coin >=0){
                    dp[i] = Math.min(dp[i],dp[i-coin]+1);
                }
            }
        }
        
        return dp[amount] == n ? -1 : dp[amount];

    }
}