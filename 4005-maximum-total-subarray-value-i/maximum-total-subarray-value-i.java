class Solution {
    public long maxTotalValue(int[] nums, int k) {
        if(k==0) return 0;
        int n=nums.length;
        Arrays.sort(nums);
        int l=n-1;
        long totalSum=0;
        for(int ind=0;ind<n-1;ind++){
            while(k!=0){
                k--;
                long maxEl=nums[n-1];
                long minEl=nums[0];
                long value=maxEl-minEl;
                totalSum+=value;
            }    
        }
        return totalSum;
        
    }
}