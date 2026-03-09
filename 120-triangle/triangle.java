class Solution {
    public int minPath(List<List<Integer>>triangle,int row,int col,Integer[][]dp){
        if(dp[row][col]!=null) return dp[row][col];
        if(row==triangle.size()-1){
            return dp[row][col]=triangle.get(row).get(col);
        }
        int down=triangle.get(row).get(col)+minPath(triangle,row+1,col,dp);
        int rightDiagonal=triangle.get(row).get(col)+minPath(triangle,row+1,col+1,dp);
        return dp[row][col]=Math.min(down,rightDiagonal);
        

    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int row=triangle.size();
        Integer[][]dp=new Integer[row][row];
        for(Integer[]rows:dp){
            Arrays.fill(rows,null);
        }
        return minPath(triangle,0,0,dp);
        
    }
}