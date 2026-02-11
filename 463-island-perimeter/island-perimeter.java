class Solution {
    private int[]dr={-1,1,0,0};
    private int[]dc={0,0,-1,1};
    public boolean isNotValid(int i,int j,int row,int col){
        if(i<0 || i>=row || j<0 ||j>=col){
            return true;
        }
        return false;
    }
    public int islandPerimeter(int[][] grid) {
        int countPerimeter=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    for(int k=0;k<4;k++){
                        int newRow=i+dr[k];
                        int newCol=j+dc[k];
                        countPerimeter+=checker(newRow,newCol,grid.length,grid[0].length,grid);
                    }
                }

            }
        }return countPerimeter;
        
    }
    public int checker(int row,int col,int totalRows,int totalCols,int[][]grid){
        if(isNotValid(row,col,totalRows,totalCols)) return 1;
        else{
            if(grid[row][col]==1) return 0;
            else return 1;
        }
    }
}