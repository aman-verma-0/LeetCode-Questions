class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int l=strs.length;
        int[][][]dp=new int[l][m+1][n+1];
        for(int[][]x:dp){
            for(int[]row:x){
                Arrays.fill(row,-1);
            }
        }
        return largestSubset(0,m,n,strs,dp);
        
    }
    public int largestSubset(int i,int zeros,int ones,String[]strs,int[][][]dp){
        if(i==strs.length) return 0;
        if(dp[i][zeros][ones]!=-1) return dp[i][zeros][ones];
        int cz=count('0',strs[i]);
        int co=count('1',strs[i]);
        int take=0;
        if(cz<=zeros && co<=ones){
            take=1+largestSubset(i+1,zeros-cz,ones-co,strs,dp);
        }
        int notTake=largestSubset(i+1,zeros,ones,strs,dp);
        return dp[i][zeros][ones]=Math.max(take,notTake);
    }
    public int count(char ch,String str){
        int n=str.length();
        int count=0;
        for(int i=0;i<n;i++){
            if(str.charAt(i)==ch) count++;
        }
        return count;
    }
}