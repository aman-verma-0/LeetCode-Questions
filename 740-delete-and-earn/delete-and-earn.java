class Solution {
    public int deleteAndEarn(int[] nums) {
        int n=nums.length;
        int max=10000;
        int[]valArr=new int[10001];
        for(int x:nums){
            valArr[x]+=x;
        }
        int[]dp=new int[10001];
        Arrays.fill(dp,-1);
        return (int)findMaxPoint(max,valArr,dp);
        
    }
    public long findMaxPoint(int points,int[]valArr,int []dp){
        if(points<1) return 0;
        if(dp[points]!=-1) return dp[points];
        // long notpick=0;
        long pick=valArr[points]+findMaxPoint(points-2,valArr,dp);
        long notpick=findMaxPoint(points-1,valArr,dp);
        long ans=Math.max(pick,notpick);
        return dp[points]=(int)ans;
    }
}