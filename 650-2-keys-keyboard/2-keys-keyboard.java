class Solution {
    public int minSteps(int n) {
        int [][]dp=new int[n+1][n+1];
        for(int []rows:dp){
            Arrays.fill(rows,-1);
        }
        
        return solve(1,0,n,dp);
        
    }
    public int solve(int wordLen,int copyLen,int n,int[][]dp){
        if(wordLen==n) return 0;
        if(wordLen>n) return Integer.MAX_VALUE;
        if(dp[wordLen][copyLen]!=-1) return dp[wordLen][copyLen];
        int paste=Integer.MAX_VALUE;
        int copy=Integer.MAX_VALUE;
        if(copyLen>0 && wordLen+copyLen<=n){
            int next=solve(wordLen+copyLen,copyLen,n,dp);
            if(next!=Integer.MAX_VALUE){
                paste=1+next;
            }
        }
        if(copyLen!=wordLen){
            int copyNext=solve(wordLen,wordLen,n,dp);
            if(copyNext!=Integer.MAX_VALUE){
                copy=1+copyNext;
            }
        }
        return dp[wordLen][copyLen]=Math.min(copy,paste);
    }
}