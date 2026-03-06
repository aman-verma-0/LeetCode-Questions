class Solution {
    public int deleteAndEarn(int[] nums) {
        int n=nums.length;
        int max=10000;
        long[]val=new long[max+1];
        for(int X:nums){
            val[X]+=X;
        }
        long[]dp=new long[max+1];
        Arrays.fill(dp,-1);
        return (int)calEarning(max,val,dp);
        
    }
    public long calEarning(int max,long[]val,long[]dp){
        if(max<1) return 0;
        if(dp[max]!=-1) return dp[max];
        long pick=val[max]+calEarning(max-2,val,dp);
        long notpick=calEarning(max-1,val,dp);
        return dp[max]=Math.max(pick,notpick);
    }
}