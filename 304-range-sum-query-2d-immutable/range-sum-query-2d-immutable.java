class NumMatrix {
    int n;
    int m;
    SegmentTree obj;
    class SegmentTree{
        int[][]segTree;
        int n;
        int m;
        SegmentTree(int n,int m){
            this.n=n;
            this.m=m;
            segTree=new int[n][m];
        }
        void buildTree(int[][]mat){
            int sum1=0;
            int sum2=0;
            for(int j=0;j<m;j++){
                segTree[0][j]=sum1+mat[0][j];
                sum1+=mat[0][j];
            }
            for(int i=0;i<n;i++){
                segTree[i][0]=sum2+mat[i][0];
                sum2+=mat[i][0];
            }
            for(int i=1;i<n;i++){
                for(int j=1;j<m;j++){
                    segTree[i][j]=mat[i][j]+segTree[i-1][j]+segTree[i][j-1]-segTree[i-1][j-1];
                }
            }
            return;
        }
        int query(int row1,int col1,int row2,int col2){
            return validValue(row2,col2,n,m)+validValue(row1-1,col1-1,n,m)-validValue(row1-1,col2,n,m)-validValue(row2,col1-1,n,m);

        }
        int validValue(int row,int col,int n,int m){
            if(row<0 || col<0 || row>=n || col>=m) return 0;
            return segTree[row][col];
        }
    }

    public NumMatrix(int[][] matrix) {
        this.n=matrix.length;
        this.m=matrix[0].length;
        obj=new SegmentTree(n,m);
        obj.buildTree(matrix);

        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return obj.query(row1,col1,row2,col2);
        
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */