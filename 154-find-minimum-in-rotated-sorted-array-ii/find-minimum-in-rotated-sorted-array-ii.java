class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        int ans=Integer.MAX_VALUE;
        int left=0;
        int right=n-1;
        if(n==1) return nums[0];
        while(left<=right){
            if(nums[left]<nums[right]){
                ans=Math.min(ans,nums[left]);
                break;
            }
            int mid=left+(right-left)/2;
            ans=Math.min(ans,nums[mid]);

            if(nums[left]<nums[mid]){
                ans=Math.min(ans,nums[left]);
                left=mid+1;
            }
            else if(nums[mid]<nums[left]){
                right=mid-1;
            }
            else left++;
        }
        return ans;
    }
}