class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1=text1.length();
        int n2=text2.length();
        int[][]dp=new int[n1+1][n2+1];
        for(int i=n1-1;i>=0;i--){
            for(int j=n2-1;j>=0;j--){
                int pick=0;
                int skip=0;
                if(text1.charAt(i)==text2.charAt(j)){
                    pick=1+dp[i+1][j+1];
                }else{
                    skip=Math.max(dp[i+1][j],dp[i][j+1]);
                }
                dp[i][j]=Math.max(pick,skip);
            }
        }
        return dp[0][0];
        
    }
}