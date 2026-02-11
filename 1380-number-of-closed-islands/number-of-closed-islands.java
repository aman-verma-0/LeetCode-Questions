class Solution {

    private int[] dr = {-1, 1, 0, 0};
    private int[] dc = {0, 0, -1, 1};

    public boolean isValid(int i,int j,int row,int col){
        if((i>=0 && i<row ) && (j>=0 &&j<col)){
            return true;
        }
        return false;
    }

    public int closedIsland(int[][] grid) {
        int count=0;
        int row=grid.length;
        int col=grid[0].length;
        int[][]vis=new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                int cur=grid[i][j];
                if(cur==0 && vis[i][j]==0){
                    count+=bfs(i,j,vis,grid);
                }
            }
        }return count;
        
    }

    public int bfs(int i,int j,int[][]vis,int[][]grid){
        int flag=1;
        Queue<int[]>q=new LinkedList<>();
        q.offer(new int[]{i,j});
        if(i==0 || i==grid.length-1 || j==0 || j==grid[0].length-1) flag=0;
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
                if(isValid(newRow,newCol,m,n) && grid[newRow][newCol]==0 && vis[newRow][newCol]==0){
                    vis[newRow][newCol]=1;
                    if(newRow==0 || newRow==grid.length-1 || newCol==0 || newCol==grid[0].length-1) flag=0;
                    q.offer(new int[]{newRow,newCol});
                }
            }
        }
        return flag;
    }
}