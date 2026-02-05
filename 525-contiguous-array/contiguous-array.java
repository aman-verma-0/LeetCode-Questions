class Solution {
    public int findMaxLength(int[] nums) {
        int n=nums.length;
        Map<Integer,Integer>map=new HashMap<>();
        map.put(0,-1);
        int left=0,right=0,maxLen=0,prefixSum=0;
        while(right<n){
            if(nums[right]==0) prefixSum-=1;
            else prefixSum+=1;
            if(map.containsKey(prefixSum)){
                int len=right-map.get(prefixSum);
                maxLen=Math.max(maxLen,len);
            }
            else{
                map.put(prefixSum,right);
            }
            right++;
        }
        return maxLen;
    }
}