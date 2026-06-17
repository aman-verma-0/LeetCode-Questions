class Solution {
    public int minCost(int n, int[] cuts) {
        int m=cuts.length;
        int[]cut= new int[m+2];
        cut[m+1]=n;
        for(int i=0;i<m;i++ ){
            cut[i+1]=cuts[i];
        }
        Arrays.sort(cut);
        int[][]dp=new int[m+2][m+2];
        for(int rows[]:dp){
            Arrays.fill(rows,-1);
        }
        return solve(1,m,cut,dp);
    
        
    }
    public int solve(int i,int j,int[]cuts,int[][]dp){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int mini=Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            int cost=cuts[j+1]-cuts[i-1]+solve(i,k-1,cuts,dp)+solve(k+1,j,cuts,dp);
            mini=Math.min(mini,cost);

        }
        return dp[i][j]=mini;
    }
}