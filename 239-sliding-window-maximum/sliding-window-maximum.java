class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        Deque<Integer> dq=new LinkedList<>();
        int[]ans=new int[n-k+1];
        int idx=0;
        for(int i=0;i<n;i++){
            while(!dq.isEmpty() && nums[i]>=nums[dq.peekLast()] ){
                dq.pollLast();
            }
            while(!dq.isEmpty() && dq.peekFirst()<=i-k){
                dq.pollFirst();
            }
            dq.offerLast(i);
            if(i>=k-1){
                ans[idx++]=nums[dq.peekFirst()];
            }



        }
        return ans;
        
    }
}