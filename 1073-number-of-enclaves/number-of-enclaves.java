class Solution {
    private int[] delRow={-1,0,1,0};
    private int[] delCol={0,1,0,-1};
    public boolean isValid(int i,int j,int m,int n){
        if(i<0||i>=m||j<0||j>=n) return false;
        return true;
    }
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][]vis=new int[m][n];
        Queue<int[]>q=new LinkedList<>();
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((i==0||i==m-1 || j==0||j==n-1) && (grid[i][j]==1)){
                    q.offer(new int[]{i,j});
                    vis[i][j]=1;
                }
            }
        }
        while(!q.isEmpty()){
            int[]cur=q.poll();
            int row=cur[0];
            int col=cur[1];
            for(int k=0;k<4;k++){
                int newRow=row+delRow[k];
                int newCol=col+delCol[k];
                if(isValid(newRow,newCol,m,n) && grid[newRow][newCol]==1 && vis[newRow][newCol]==0){
                    vis[newRow][newCol]=1;
                    q.offer(new int[]{newRow,newCol});
                }
            }
            
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && vis[i][j]==0){
                    count++;
                }
            }
        }
        return count;
        
    }
}