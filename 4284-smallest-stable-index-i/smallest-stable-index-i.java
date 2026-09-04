class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        int ssi=-1;
        int[]maxArray=new int[n];
        int []minArray=new int[n];
        int curMax=-1;
        for(int i=0;i<n;i++){
            curMax=Math.max(curMax,nums[i]);
            maxArray[i]=curMax;
        }
        int curMin=Integer.MAX_VALUE;
        for(int i=n-1;i>=0;i--){
            curMin=Math.min(curMin,nums[i]);
            minArray[i]=curMin;
        }
        for(int i=n-1;i>=0;i--){
            int score=maxArray[i]-minArray[i];
            if(score<=k) ssi=i;

        }
        return ssi;
    }
}