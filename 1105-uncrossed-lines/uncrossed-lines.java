class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        int[][]dp=new int[n1+1][n2+1];
        for(int i=n1-1;i>=0;i--){
            for(int j=n2-1;j>=0;j--){
                int pick=0;
                if(nums1[i]==nums2[j]){
                    pick=1+dp[i+1][j+1];
                }
                int skip=Math.max(dp[i+1][j],dp[i][j+1]);
                dp[i][j]=Math.max(pick,skip);
            }
        }
        return dp[0][0];
        
    }
}