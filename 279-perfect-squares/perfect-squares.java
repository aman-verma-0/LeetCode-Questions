class Solution {
    public int numSquares(int n) {
        int[]dp=new int[n+1];
        Arrays.fill(dp,-1);
         findMinNum(1,n,dp);
         return dp[n];
        
    }
    public int findMinNum(int i,int n,int[]dp ){
        if(n==0) return 0;
        if(i*i>n) return Integer.MAX_VALUE;
        if(dp[n]!=-1) return dp[n];
        
        int pick=Integer.MAX_VALUE;

        if((i*i)<=n){
            int next=findMinNum(i,n-(i*i),dp);
            if(next!=Integer.MAX_VALUE){
                pick=1+next;
            }  
        }
        int notpick=findMinNum(i+1,n,dp);
        return dp[n]=Math.min(pick,notpick);
    }
}