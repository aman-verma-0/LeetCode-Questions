class Solution {
    int[] dr={-1,1,0,0};
    int[] dc={0,0,-1,1};
    public boolean isValid(int i,int j,int n,int m){
        if((i>=0 && i<n) &&(j>=0 && j<m)){
            return true;
        }
        return false;
    }
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q=new LinkedList<>();
        int n=mat.length;
        int m=mat[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.offer(new int[]{i,j});
                }
                else{
                    mat[i][j]=-1;
                }
            }
        }
        bfs(q,mat);
        return mat;
        
    }
    public void bfs(Queue<int[]>q,int[][] mat){
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int row=curr[0];
            int col=curr[1];
            for(int k=0;k<4;k++){
                int newRow=row+dr[k];
                int newCol=col+dc[k];
                if(isValid(newRow,newCol,mat.length,mat[0].length) && mat[newRow][newCol]==-1){
                    mat[newRow][newCol]=mat[row][col]+1;
                    q.offer(new int[]{newRow,newCol});
                }
            }
        }
        return;

    }
}