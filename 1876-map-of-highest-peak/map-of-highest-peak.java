class Solution {
    int[]dr={-1,1,0,0};
    int[]dc={0,0,-1,1};
    public boolean isValid(int row,int col,int m,int n){
        if(row>=0 && col>=0 && row<m && col<n) return true;
        return false;
    }
    public int[][] highestPeak(int[][] isWater) {
        int m=isWater.length;
        int n=isWater[0].length;
        int[][] height=new int[m][n];
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(isWater[i][j]==1){
                    height[i][j]=0;
                    q.offer(new int[]{i,j});
                }
            }
        }while(!q.isEmpty()){
            int curr[]=q.poll();
            int row=curr[0];
            int col=curr[1];
            int curHeight=height[row][col];
            for(int k=0;k<4;k++){
                int newRow=row+dr[k];
                int newCol=col+dc[k];
                if(isValid(newRow,newCol,m,n) && isWater[newRow][newCol]==0 && height[newRow][newCol]==0 ){
                    height[newRow][newCol]=curHeight+1;
                    q.offer(new int[]{newRow,newCol});
                }
            }
        }
        return height;



        
    }
}