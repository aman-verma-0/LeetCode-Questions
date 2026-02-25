class Solution {
    int[]dr={1,0};
    int[]dc={0,1};
    public boolean isValid(int i,int j,int row,int col){
        if(i<0||j<0||i>=row||j>=col) return false;
        return true;
    }
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][]dist=new int[n][m];
        for(int rows[]:dist){
            Arrays.fill(rows,Integer.MAX_VALUE);
        }
        PriorityQueue<int[]>q=new PriorityQueue<>((a,b)->Integer.compare(a[2],b[2]));
        q.add(new int[]{0,0,grid[0][0]});
        dist[0][0]=grid[0][0];
        while(!q.isEmpty()){
            int []cur=q.poll();
            int row=cur[0];
            int col=cur[1];
            int wt=cur[2];
            for(int i=0;i<2;i++){
                int nRow=row+dr[i];
                int nCol=col+dc[i];
                if(isValid(nRow,nCol,n,m)){
                    int newWt=wt+grid[nRow][nCol];
                    if(dist[nRow][nCol]>newWt){
                        dist[nRow][nCol]=newWt;
                        q.add(new int[]{nRow,nCol,dist[nRow][nCol]});
                    }
                }
            }
        }
        return dist[n-1][m-1];
        
    }
}