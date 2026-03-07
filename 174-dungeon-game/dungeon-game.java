class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int n=dungeon.length;
        int m=dungeon[0].length;
        Integer[][]dp=new Integer[n+1][m+1];
        for(Integer rows[]:dp){
           Arrays.fill(rows,null);
        }
        return knightPower(0,0,dungeon,dp);
        
    }
    public int knightPower(int i,int j,int[][]dungeon,Integer[][]dp){
        int n=dungeon.length;
        int m=dungeon[0].length;
        if(i>=n || j>=m) return Integer.MAX_VALUE;
        if(i==n-1 && j==m-1) return Math.max(1,1-dungeon[i][j]);
        if(dp[i][j]!=null) return dp[i][j];
        int cur=Math.min(knightPower(i+1,j,dungeon,dp),knightPower(i,j+1,dungeon,dp))-dungeon[i][j];
        return dp[i][j]=Math.max(1,cur);
    }
}