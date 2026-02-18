class Solution {
    public boolean stoneGame(int[] nums) {
        int n=nums.length;
        Integer[][]dp=new Integer[n+1][n+1];
        int result=findScore(0,n-1,nums,dp);

        return result>=0;
        
    }
    public int findScore(int left,int right,int[]nums,Integer[][]dp){
        if(left==right) return nums[left];
        if(dp[left][right]!=null) return dp[left][right];
        
        int lefttake=nums[left]-findScore(left+1,right,nums,dp);
        int righttake=nums[right]-findScore(left,right-1,nums,dp);
        return dp[left][right]=Math.max(lefttake,righttake);
    }
}