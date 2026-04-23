class Solution {
    public int minDistance(String word1, String word2) {
        int n1=word1.length();
        int n2=word2.length();
        int[][]dp=new int[n1+1][n2+1];
        for(int []rows:dp){
            Arrays.fill(rows,-1);
        }
        return minOperation(0,0,word1,word2,dp);
    }
    public int minOperation(int i,int j,String s1,String s2,int[][]dp){
        if(i == s1.length()) return s2.length() - j;
        if(j == s2.length()) return s1.length() - i;
        if(dp[i][j]!=-1) return dp[i][j];
        int skip=Integer.MAX_VALUE,pick1=Integer.MAX_VALUE,pick2=Integer.MAX_VALUE,pick3=Integer.MAX_VALUE;
        if(s1.charAt(i)==s2.charAt(j)){
            skip=minOperation(i+1,j+1,s1,s2,dp);
        }
        else{
            pick1=1+minOperation(i,j+1,s1,s2,dp);
            pick2=1+minOperation(i+1,j,s1,s2,dp);
            pick3=1+minOperation(i+1,j+1,s1,s2,dp);
        }
        return dp[i][j]=Math.min(Math.min(skip,pick1),Math.min(pick2,pick3));
    }
}