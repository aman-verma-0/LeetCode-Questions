class Solution {
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        int[][]dp=new int[n+1][n+1];
        for(int i=0;i<n;i++){
            dp[i][i]=1;
        }
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                int equal=0;
                int skip=0;
                if(s.charAt(i)==s.charAt(j)){
                    equal=2+dp[i+1][j-1];
                }else {
                    int skip1=dp[i+1][j];
                    int skip2=dp[i][j-1];
                    skip=Math.max(skip1,skip2);
                }
                dp[i][j]=Math.max(equal,skip);
            }
        }
        return dp[0][n-1];


        
    }
}