class Solution {
    public int maximumAmount(int[][] coins) {
        int n=coins.length;
        int m=coins[0].length;
        int[][][]dp=new int[n][m][3];
        for(int[][]arr:dp){
            for(int row[]:arr){
                Arrays.fill(row,Integer.MIN_VALUE);
            }
        }
        return findMaxAmount(0,0,2,coins,dp);
        
    }
    public int findMaxAmount(int i,int j,int temp,int [][]arr,int[][][]dp){
        if(i==arr.length-1 && j==arr[0].length-1){
            if (arr[i][j] < 0 && temp > 0) return 0;
            return arr[i][j];
        }
        if(i>=arr.length || j>=arr[0].length) return Integer.MIN_VALUE;
        if(dp[i][j][temp]!=Integer.MIN_VALUE) return dp[i][j][temp];
        int ans=Integer.MIN_VALUE;
        int right = findMaxAmount(i, j+1, temp, arr, dp);
        int down  = findMaxAmount(i+1, j, temp, arr, dp);


        if (right != Integer.MIN_VALUE) {
            ans = Math.max(ans, arr[i][j] + right);
        }
        if (down != Integer.MIN_VALUE) {
            ans = Math.max(ans, arr[i][j] + down);
        }
        if(arr[i][j]<0 && temp>0 ){
            int right2=findMaxAmount(i,j+1,temp-1,arr,dp);
            int down2=findMaxAmount(i+1,j,temp-1,arr,dp);
            int skip=Math.max(right2,down2);
            ans=Math.max(skip,ans);
        }
        return dp[i][j][temp]=ans;
        
    }
}