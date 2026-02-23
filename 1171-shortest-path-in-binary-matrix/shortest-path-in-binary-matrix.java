class Solution {
    int []dr={-1,1,0,0,-1,1,-1,1};
    int []dc={0,0,-1,1,1,1,-1,-1};
    public boolean isValid(int i,int j,int n,int m){
        if(i<0 || j<0 || i>=n ||j>=m) return false;
        return true;
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        Queue<int[]>q=new LinkedList<>();
        boolean[][]vis=new boolean[n][n];
        if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1;
        q.add(new int[]{0,0});
        vis[0][0]=true;
        int[][]dist=new int[n][n];
        
        for(int row[]:dist){
            Arrays.fill(row,(int)1e9);
        }
        dist[0][0]=1;
        
        while(!q.isEmpty()){
            int []cur=q.poll();
            int row=cur[0];
            int col=cur[1];
            for(int k=0;k<8;k++){
                int newRow=row+dr[k];
                int newCol=col+dc[k];
                if(isValid(newRow,newCol,n,n) && vis[newRow][newCol]==false && grid[newRow][newCol]==0){
                    vis[newRow][newCol]=true;
                    q.add(new int[]{newRow,newCol});
                    if(dist[row][col]+1<dist[newRow][newCol]){
                        dist[newRow][newCol]=dist[row][col]+1;
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(dist[i][j]==(int)1e9) dist[i][j]=-1;
            }
        }
        return dist[n-1][n-1];


        
    }
}