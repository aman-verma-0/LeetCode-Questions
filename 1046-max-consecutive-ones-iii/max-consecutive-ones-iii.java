class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        int longestLen=0;
        int Zeros=0;
        int left=0,right=0;
        while(right<n){
            if(nums[right]==0) Zeros++;
            while(Zeros>k){
                if(nums[left]==0){
                    Zeros--;      
                }
                left++;
            }
            right++;
            longestLen=Math.max(longestLen,right-left);


        }
        return longestLen;
        
    }
}