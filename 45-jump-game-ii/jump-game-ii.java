class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        int[]dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(0,nums,dp);   
    }
    public int solve(int i,int[]nums,int[]dp){
        if(i==nums.length-1) return 0;
        if(i>=nums.length) return Integer.MAX_VALUE;
        if(dp[i]!=-1) return dp[i];
        int ans=Integer.MAX_VALUE;
        for(int j=1;j<=nums[i];j++){
            int next=solve(i+j,nums,dp);
            if(next!=Integer.MAX_VALUE){
                int pick=1+next;
                ans=Math.min(ans,pick);
            }

        }
        return dp[i]=ans;


    }
}