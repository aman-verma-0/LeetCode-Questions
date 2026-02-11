class Solution {
    private int[] dr = {-1, 1, 0, 0};
    private int[] dc = {0, 0, -1, 1};
    public int numIslands(char[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int[][]vis=new int[row][col];
        int ans=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                char cur=grid[i][j];
                if(cur=='1' && vis[i][j]==0){
                    ans++;
                    bfs(i,j,vis,grid);
                }
            }
        }
        return ans;   
    }
    public void bfs(int i,int j,int[][]vis,char[][]grid){
        Queue<int[]>q=new LinkedList<>();
        q.offer(new int[]{i,j});
        if(vis[i][j]==1) return;
        vis[i][j]=1;
        int m=grid.length;
        int n=grid[0].length;
        while(!q.isEmpty()){
            int[]cur=q.poll();
            int row=cur[0];
            int col=cur[1];
            for(int k=0;k<4;k++){    
                int newRow = row + dr[k];
                int newCol = col + dc[k];
                if(isValid(newRow,newCol,m,n) && grid[newRow][newCol]=='1' && vis[newRow][newCol]==0){
                    vis[newRow][newCol]=1;
                    q.offer(new int[]{newRow,newCol});
                }
            }
        }
    }
    public boolean isValid(int i,int j,int row,int col){
        if((i>=0 && i<row ) && (j>=0 &&j<col)){
            return true;
        }
        return false;
    }
}