class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int val:nums) sum+=val;
        if(sum%2!=0) return false;
        sum=sum/2;
        Boolean[][]dp=new Boolean[n+1][sum+1];
        for(Boolean[]rows:dp){
            Arrays.fill(rows,null);
        }
        return isPartitionPossible(0,sum,dp,nums);

        
    }
    public Boolean isPartitionPossible(int i,int sum,Boolean[][]dp,int[]arr){
        if(i==arr.length){
            if(sum==0) return true;
            return false;
        }
        if(dp[i][sum]!=null) return dp[i][sum];
        Boolean take=false;
        if(arr[i]<=sum){
            take=isPartitionPossible(i+1,sum-arr[i],dp,arr);
        }
        Boolean skip=isPartitionPossible(i+1,sum,dp,arr);
        return dp[i][sum]=take||skip;
    }
}