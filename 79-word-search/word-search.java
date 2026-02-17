class Solution {
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0)){
                    if(func(board,i,j,word,0)){
                        return true;
                    }
                }
            }
        }return false;  
    }
    private boolean func(char[][] board,int i,int j,String word,int k){
        if(k==word.length()){
            return true;
        }
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j]!=word.charAt(k)){
            return false;
        }
        char temp=board[i][j];
        board[i][j]=' ';
        boolean ans=func(board,i+1,j,word,k+1) ||
                    func(board,i-1,j,word,k+1) ||
                    func(board,i,j+1,word,k+1) ||
                    func(board,i,j-1,word,k+1);
        board[i][j]=temp;
        return ans;
    }
}