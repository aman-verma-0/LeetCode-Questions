class Solution {
    private int[] dr = {-1, 1, 0, 0};
    private int[] dc = {0, 0, -1, 1};
    public boolean isValid(int i,int j,int row,int col){
        if((i>=0 && i<row ) && (j>=0 &&j<col)){
            return true;
        }
        return false;
    }
    public boolean containsCycle(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][]vis=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==false){
                    if(bfs(i,j,grid[i][j],grid,vis)) return true;
                }
            }
        }return false;  
    }
    public boolean bfs(int i,int j,char ch,char[][]grid,boolean[][]vis){
        Queue<int[]>q=new LinkedList<>();
        q.add(new int[]{i,j,-1,-1});
        vis[i][j]=true;
        while(!q.isEmpty()){
            int curr[]=q.poll();
            int row=curr[0];
            int col=curr[1];
            int pi=curr[2];
            int pj=curr[3];
            for(int k=0;k<4;k++){
                int newRow=row+dr[k];
                int newCol=col+dc[k];
                if(isValid(newRow,newCol,grid.length,grid[0].length) && grid[newRow][newCol]==ch){
                    if(vis[newRow][newCol]==false){
                        q.add(new int[]{newRow,newCol,row,col});
                        vis[newRow][newCol]=true;
                    }
                    else if(pi!=newRow || pj!=newCol) return true;
                }
            }

        }return false;
    }
}