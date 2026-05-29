class Solution {
    public int minElement(int[] nums) {
        int n=nums.length;
        int mini=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int curSum=0;
            int num=nums[i];
            while(num>0){
                int rem=num%10;
                curSum+=rem;
                num/=10;
            }
            mini=Math.min(mini,curSum);
        }
        return mini;
        
    }
}