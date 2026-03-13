class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n=stones.length;
        int sum=0;
        for(int x:stones){
            sum+=x;
        }
        int target=sum/2;
        int[][]dp=new int[n][target+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        int best=findSI(0,target,stones,dp);
        return sum-2*best;
    }
    public int findSI(int i,int target,int[]stones,int[][]dp){
        if(i==stones.length) return 0;
        if(dp[i][target]!=-1) return dp[i][target];
        int take=0;
        if(stones[i]<=target){
            take=stones[i]+findSI(i+1,target-stones[i],stones,dp);
        }
        int notTake=findSI(i+1,target,stones,dp);
        return dp[i][target]=Math.max(take,notTake);
    }
}