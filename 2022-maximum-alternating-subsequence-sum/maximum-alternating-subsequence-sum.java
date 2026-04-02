class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n=nums.length;
        long[][]dp=new long[n+1][2];
        for(long row[]:dp){
            Arrays.fill(row,-1);
        }
        return findMaxSum(0,1,nums,dp);
        
    }
    public long findMaxSum(int i,int flag,int[]nums,long[][]dp){
        if(i==nums.length) return 0;
        if(dp[i][flag]!=-1) return dp[i][flag];
        long pick=0;
        if(flag==1){
            pick=nums[i]+findMaxSum(i+1,0,nums,dp);
        }else{
            pick=(-nums[i])+findMaxSum(i+1,1,nums,dp);
        }
        long notpick=findMaxSum(i+1,flag,nums,dp);
        return dp[i][flag]=Math.max(pick,notpick);
    }
}