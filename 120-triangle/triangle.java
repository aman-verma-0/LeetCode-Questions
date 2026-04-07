class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m=triangle.size();
        Integer[][]dp=new Integer[m][m];
        dp[0][0]=triangle.get(0).get(0);
        for(int i=1;i<m;i++){
            dp[i][0]=dp[i-1][0]+triangle.get(i).get(0);
            dp[i][i]=dp[i-1][i-1]+triangle.get(i).get(i);
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<=i;j++){
                if(dp[i][j]==null){
                    dp[i][j]=Math.min(dp[i-1][j],dp[i-1][j-1])+triangle.get(i).get(j);
                }
            }
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            ans=Math.min(dp[m-1][i],ans);
        }
        return ans;
    }
}