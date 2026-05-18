class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n=nums.length;
        int lcis=1,count=1;
        for(int i=1;i<n;i++){
            if(nums[i]>nums[i-1]){
                count=count+1;
                lcis=Math.max(lcis,count);
            }
            else count=1;
        }
        lcis=Math.max(lcis,count);
        return lcis;

        
    }
}