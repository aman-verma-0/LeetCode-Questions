class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][]dp=new int[n+1][amount+1];
        for(int rows[]:dp){
            Arrays.fill(rows,-1);
        }
        return noOfCombinations(0,amount,coins,dp);


        
    }
    public int noOfCombinations(int i,int amount,int[]coins,int[][]dp){
        if(amount==0) return 1;
        if(i==coins.length) return 0;
        if(dp[i][amount]!=-1) return dp[i][amount];
        int pick=0;
        if(coins[i]<=amount){
            pick=noOfCombinations(i,amount-coins[i],coins,dp);
        }
        int skip=noOfCombinations(i+1,amount,coins,dp);
        return dp[i][amount]=pick+skip;
    }
}