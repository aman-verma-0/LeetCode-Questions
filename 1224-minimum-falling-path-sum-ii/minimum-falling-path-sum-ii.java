class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n=grid.length;
        Integer[][]dp=new Integer[n][n];
        for(Integer rows[]:dp){
            Arrays.fill(rows,Integer.MAX_VALUE);
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            ans=Math.min(ans,solve(0,i,grid,dp));
        }
        return ans;
    }
    public int solve(int i,int j,int[][]grid,Integer[][]dp){
        int n=grid.length;
        if(j<0||j>=n) return Integer.MAX_VALUE;
        if(i==n-1) return grid[i][j];
        if(dp[i][j]!=Integer.MAX_VALUE) return dp[i][j];
        int path=Integer.MAX_VALUE;
        for(int k=0;k<n;k++){
            if(k!=j){
                path=Math.min(path,solve(i+1,k,grid,dp));
            }
        }
        // int leftD=solve(i+1,j-1,grid,dp);
        // int rightD=solve(i+1,j+1,grid,dp);
        // int path=Math.min(leftD,rightD);
        return dp[i][j]=grid[i][j]+path;
    }
}