class Solution {
    public int minDistance(String word1, String word2) {
        int n1=word1.length();
        int n2=word2.length();
        int[][]dp=new int[n1+1][n2+1];
        for(int i=n1-1;i>=0;i--){
            for(int j=n2-1;j>=0;j--){
                int pick=0;
                int skip=0;
                if(word1.charAt(i)==word2.charAt(j)){
                    pick=1+dp[i+1][j+1];
                }else{
                    skip=Math.max(dp[i+1][j],dp[i][j+1]);
                }
                dp[i][j]=Math.max(pick,skip);
            }
        }
        int lcs=dp[0][0];
        int l1=n1-lcs;
        int l2=n2-lcs;
        return l1+l2;
        
    }
}