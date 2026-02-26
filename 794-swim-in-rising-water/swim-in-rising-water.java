class Solution {
    int[]dr={0,0,-1,1};
    int[]dc={-1,1,0,0};
    public boolean isValid(int i,int j,int row,int col){
        if(i<0||j<0||i>=row||j>=col) return false;
        return true;
    }
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        int[][]dist=new int[n][n];
        for(int row[]:dist){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        dist[0][0]=grid[0][0];
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->Integer.compare(a[2],b[2]));
        pq.add(new int[]{0,0,grid[0][0]});
        while(!pq.isEmpty()){
            int []curr=pq.poll();
            int row=curr[0];
            int col=curr[1];
            int wt=curr[2];
            if(row==n-1 && col==n-1) return wt;
            if(wt>dist[row][col]) continue;
            for(int i=0;i<4;i++){
                int nRow=row+dr[i];
                int nCol=col+dc[i];
                if(isValid(nRow,nCol,n,n)){
                    int newWt=Math.max(wt,grid[nRow][nCol]);
                    if(newWt<dist[nRow][nCol]){
                        dist[nRow][nCol]=newWt;
                        pq.add(new int[]{nRow,nCol,newWt});
                    }
                    
                }
            }

        }
        return -1;

        
    }
}