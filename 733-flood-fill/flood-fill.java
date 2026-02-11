class Solution {
    private int[] dr = {-1, 1, 0, 0};
    private int[] dc = {0, 0, -1, 1};
    public boolean isValid(int i,int j,int row,int col){
        if((i>=0 && i<row ) && (j>=0 &&j<col)){
            return true;
        }
        return false;
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n=image.length;
        int m=image[0].length;
        Queue<int[]>q=new LinkedList<>();
        int stColor=image[sr][sc];
        if(stColor==color) return image;
        q.offer(new int[]{sr,sc});
        // boolean[][]isVis=new boolean[n][m];
        // isVis[sr][sc]=true;
        while(!q.isEmpty()){
            int[]cur=q.poll();
            int row=cur[0];
            int col=cur[1];
            image[row][col]=color;
            for(int i=0;i<4;i++){
                int newRow=row+dr[i];
                int newCol=col+dc[i];
                if(isValid(newRow,newCol,n,m) && image[newRow][newCol]==stColor /*&& isVis[newRow][newCol]==false*/){
                    // isVis[newRow][newCol]=true;
                    q.offer(new int[]{newRow,newCol});
                }
            }
        }
        return image;


        
    }
}