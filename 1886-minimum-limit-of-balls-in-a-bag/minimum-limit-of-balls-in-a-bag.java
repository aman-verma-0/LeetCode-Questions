class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int n=nums.length;
        int low=1;
        int high=(int)1e9;
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(canPerform(nums,mid,maxOperations)){
                ans=mid;
                high=mid-1;
            }else low=mid+1;
        }
        return ans;
    }
    public boolean canPerform(int[]nums,int maxBalls,int maxOp){
        long cntOp=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]>maxBalls){
                int need = (nums[i] - 1) / maxBalls;
                cntOp+=need;
                if(cntOp>maxOp) return false;
            }
           
        }return cntOp<=maxOp;
    }
}