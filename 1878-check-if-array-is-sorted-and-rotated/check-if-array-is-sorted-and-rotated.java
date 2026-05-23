class Solution {
    public boolean check(int[] nums) {
        int n=nums.length;
        int count=0;
        if(nums[0]<nums[n-1])  count++;
        for(int i=1;i<n;i++){
            if (nums[i] < nums[i - 1]) { 
                count++;
            }
            if (count > 1) {
                return false;
            }
        }return true;
        
    }
}