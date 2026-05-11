class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int [][]dp=new int[n+1][amount+1];
        for(int j=1;j<=amount;j++){
            dp[n][j]=Integer.MAX_VALUE;
        }
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=amount;j++){
                int pick=Integer.MAX_VALUE;
                if(coins[i]<=j){
                    int next=dp[i][j-coins[i]];
                    if(next!=Integer.MAX_VALUE){
                        pick=1+next;
                    }
                }
                int skip=dp[i+1][j];
                dp[i][j]=Math.min(pick,skip);
            }
        }
        return dp[0][amount]==Integer.MAX_VALUE?-1:dp[0][amount];
        
    }
}