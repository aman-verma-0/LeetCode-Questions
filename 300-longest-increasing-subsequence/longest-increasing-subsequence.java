class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int [][]dp=new int [n+1][n+1];
        for(int rows[]:dp){
            Arrays.fill(rows,-1);
        }
        return LIS(0,-1,nums,dp);
        
    }
    public int LIS(int i,int prevIdx,int[]nums,int[][]dp){
        if(i==nums.length) return 0;
        if(dp[i][prevIdx+1]!=-1) return dp[i][prevIdx+1];
        int take=0;
        if(prevIdx==-1){
            take=1+LIS(i+1,i,nums,dp);
        }
        else if(nums[prevIdx]<nums[i]){
            take=1+LIS(i+1,i,nums,dp);
        }
        int skip=LIS(i+1,prevIdx,nums,dp);
        return dp[i][prevIdx+1]=Math.max(take,skip);
    }
}