class Solution {
    public int minFallingPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Integer[][]dp=new Integer[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0){
                    dp[i][j]=grid[i][j];
                }
                else{
                    int k=0;
                    int minInRow=Integer.MAX_VALUE;
                    while(k<n){
                        if(k==j){
                            k++;
                            continue;

                        }
                        else{
                            minInRow=Math.min(minInRow,dp[i-1][k]);
                            k++; 
                        }  
                    }

                    dp[i][j]=grid[i][j]+minInRow;
                    
                }
            }
        }
        int ans=Integer.MAX_VALUE;
        for(int j=0;j<n;j++){
            ans=Math.min(ans,dp[m-1][j]);
        }
        return ans;
        
    }
}