class Solution {
    class Pair{
        int row;
        int col;
        int effort;
        public Pair(int row,int col,int effort){
            this.row=row;
            this.col=col;
            this.effort=effort;
        }
    }
    int[]dr={-1,1,0,0};
    int[]dc={0,0,-1,1};
    public boolean isValid(int i,int j, int row,int col){
        if(i<0 || j<0 || i>=row || j>=col) return false;
        return true;
    }
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        int[][]dist=new int[n][m];
        for(int []row:dist){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        dist[0][0]=0;
        PriorityQueue<Pair>q=new PriorityQueue<>((a,b)->Integer.compare(a.effort,b.effort));
        int ans=Integer.MAX_VALUE;
        q.add(new Pair(0,0,0));
        while(!q.isEmpty()){
            Pair cur=q.poll();
            int row=cur.row;
            int col=cur.col;
            int effort=cur.effort;
            if(row==n-1 && col==m-1) return effort;
            for(int i=0;i<4;i++){
                int newRow=row+dr[i];
                int newCol=col+dc[i];
                if(isValid(newRow,newCol,n,m)){
                    int curEfrt=Math.abs(heights[newRow][newCol]-heights[row][col]);
                    int newEffort=Math.max(curEfrt,effort);
                    if(newEffort<dist[newRow][newCol]) {
                        dist[newRow][newCol]=newEffort;
                        q.add(new Pair(newRow,newCol,newEffort));
                    }
                }
            }
        }
        return 0;
        
    }
}