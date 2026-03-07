class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int ans=Integer.MAX_VALUE;
        int[][]dp=new int[n][m];
        for(int rows[]:dp){
            Arrays.fill(rows,Integer.MAX_VALUE);
        }
        for(int i=0;i<m;i++){
            ans=Math.min(ans,solve(0,i,matrix,dp));
        }
        return ans;     
    }
    public int solve(int i,int j,int[][]matrix,int[][]dp){
        int n=matrix.length;
        int m=matrix[0].length;
        if(j<0 || j>=m) return Integer.MAX_VALUE;
        if(i==n-1) return matrix[i][j];
        if(dp[i][j]!=Integer.MAX_VALUE) return dp[i][j];
        int leftD=solve(i+1,j-1,matrix,dp);
        int down=solve(i+1,j,matrix,dp);
        int rightD=solve(i+1,j+1,matrix,dp);
        int path=Math.min(leftD,Math.min(down,rightD));
        if(path==Integer.MAX_VALUE) return dp[i][j]=Integer.MAX_VALUE;
        return dp[i][j]=matrix[i][j]+path;
    }
}