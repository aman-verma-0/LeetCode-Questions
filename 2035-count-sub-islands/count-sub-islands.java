class Solution {
    private int[] delRow={-1,0,1,0};
    private int[] delCol={0,1,0,-1};
    private boolean isValid(int i,int j,int n,int m){
        if(i<0||i>=n||j<0||j>=m) return false;
        return true;
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n=grid1.length;
        int m=grid1[0].length;
        boolean[][]isVis=new boolean[n][m];
        int subIslands=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid2[i][j]==1 && isVis[i][j]==false){
                    subIslands+=bfs(i,j,grid1,grid2,isVis);
                }
            }
        }
        return subIslands;
        
    }
    public int bfs(int i,int j,int[][]grid1,int[][]grid2,boolean[][]isVis){
        int flag=1;
        Queue<int[]>q=new LinkedList<>();
        q.offer(new int[]{i,j});
        isVis[i][j]=true;
        if(grid1[i][j]!=1) flag=0;
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int row=curr[0];
            int col=curr[1];
            for(int k=0;k<4;k++){
                int newRow=row+delRow[k];
                int newCol=col+delCol[k];
                if(isValid(newRow,newCol,grid1.length,grid1[0].length) && isVis[newRow][newCol]==false && grid2[newRow][newCol]==1){
                    isVis[newRow][newCol]=true;
                    if(grid1[newRow][newCol]!=1) flag=0;
                    q.offer(new int[]{newRow,newCol});
                }
            }

        }return flag;
    }
}