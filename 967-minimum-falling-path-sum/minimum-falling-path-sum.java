class Solution {
    public int isValid(int i,int j,int m,int n,Integer[][]dp){
        if(i<0 || j<0|| i>=m || j>=n) return Integer.MAX_VALUE;
        return dp[i][j];
    }
    public int minFallingPathSum(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        Integer[][]dp=new Integer[m][n];
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0){
                    dp[i][j]=matrix[i][j];
                }
                else{
                    int leftD=isValid(i-1,j-1,m,n,dp);
                    int up=isValid(i-1,j,m,n,dp);
                    int rightD=isValid(i-1,j+1,m,n,dp);
                    dp[i][j]=matrix[i][j]+Math.min(leftD,Math.min(up,rightD));
                    // if(i==m-1) ans=Math.min(ans,dp[i][j]);
                }
            }
        }
        for(int j=0;j<n;j++){
            ans=Math.min(ans,dp[m-1][j]);
        }
        return ans;


        
    }
}