class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n=nums.length;
        Set<Integer> set= new HashSet<>();
        int left=0;
        int right=0;
        int currSum=0;
        int totalSum=0;
        while(right<n){
            if(!set.contains(nums[right])){
                currSum+=nums[right];
                set.add(nums[right]);
                totalSum=Math.max(currSum,totalSum);
            }
            else{
                while(set.contains(nums[right])){
                    set.remove(nums[left]);
                    currSum-=nums[left];
                    left++;
                }
                set.add(nums[right]);
                currSum+=nums[right];
            }
            right++;

        }
        return totalSum;

        
    }
}