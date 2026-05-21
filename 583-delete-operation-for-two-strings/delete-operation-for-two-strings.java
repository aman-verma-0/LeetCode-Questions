class Solution {
    public int minDistance(String word1, String word2) {
        int n1=word1.length();
        int n2=word2.length();
        int[][]dp=new int[n1+1][n2+1];
        for(int i=0;i<n1;i++){
            dp[i][n2]=n1-i;
        }
        for(int j=0;j<n2;j++){
            dp[n1][j]=n2-j;
        }
        for(int i=n1-1;i>=0;i--){
            for(int j=n2-1;j>=0;j--){
                int pick=Integer.MAX_VALUE;
                int pick1=Integer.MAX_VALUE;
                int pick2=Integer.MAX_VALUE;
                if(word1.charAt(i)==word2.charAt(j)){
                    pick=dp[i+1][j+1];
                }
                else{
                    pick1=1+dp[i+1][j];
                    pick2=1+dp[i][j+1];
                }
                dp[i][j]=Math.min(pick,Math.min(pick1,pick2));
                
            }
        }
        return dp[0][0];
    }
}