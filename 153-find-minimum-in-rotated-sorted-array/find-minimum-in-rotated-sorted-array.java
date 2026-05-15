class Solution {
    public int findMin(int[] nums) {
        int left=0;
        int right=nums.length-1;
        int minr=Integer.MAX_VALUE;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[left]<=nums[mid]){
                minr=Math.min(minr,nums[left]);
                left=mid+1;
            }else{
                minr=Math.min(minr,nums[mid]);
                right=mid-1;
            }
        }
        return minr;
        
    }
}