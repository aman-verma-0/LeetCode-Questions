class Solution {
    private int[] delRow={-1,0,1,0};
    private int[] delCol={0,1,0,-1};
    public boolean isValid(int i,int j,int n,int m){
        if((i>=0 && i<n) &&(j>=0 && j<m)){
            return true;
        }
        return false;
    }
    public int maxDistance(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] dist=new int[n][m];
        int totalOnes=0;
        int totalCols=0;
        Queue<int[]>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    // dist[i][j]=0;
                    q.offer(new int[]{i,j});
                    totalOnes++;
                }else totalCols++;
            }
        }
        if(totalOnes==0 || totalCols==0) return -1;
        return bfs(q,grid,dist);
        
    }
    public int bfs(Queue<int[]>q,int[][]grid,int[][]dist){
        int maxDist=0;
        while(!q.isEmpty()){
            int[]curr=q.poll();
            int row=curr[0];
            int col=curr[1];
            int currDist=dist[row][col];
            for(int k=0;k<4;k++){
                int newRow=row+delRow[k];
                int newCol=col+delCol[k];
                if(isValid(newRow,newCol,grid.length,grid[0].length) && grid[newRow][newCol]==0 && dist[newRow][newCol]==0){
                    dist[newRow][newCol]= currDist + Math.abs(newRow-row)+Math.abs(newCol-col);
                    maxDist=Math.max(maxDist,dist[newRow][newCol]);
                    q.offer(new int[]{newRow,newCol});

                }
            }

        }
        return maxDist;
    }
}