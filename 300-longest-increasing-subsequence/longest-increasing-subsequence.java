class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][]dp=new int[n+1][n+1];
        for(int []rows:dp){
            Arrays.fill(rows,-1);
        }
        return solve(0,-1,nums,dp);
        
    }
    public int solve(int i,int j,int[]nums,int[][]dp){
        if(i==nums.length) return 0;
        if(dp[i][j+1]!=-1) return dp[i][j+1];
        int pick=0;
        if(j==-1 || nums[j]<nums[i]){
            pick=1+solve(i+1,i,nums,dp);
        }
        int skip=solve(i+1,j,nums,dp);
        return dp[i][j+1]=Math.max(pick,skip);
    }
}