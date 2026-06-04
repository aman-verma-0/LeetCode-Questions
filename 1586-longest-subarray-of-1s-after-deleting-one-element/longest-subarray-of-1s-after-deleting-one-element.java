class Solution {
    public int longestSubarray(int[] nums) {
        int n=nums.length;
        int count=-1;
        // int[]pre=new int[n];
        // int[]suf=new int[n];
        // for(int i=0;i<n;i++){
        //     if(nums[i]==0){
        //         count=0;
        //         pre[i]=0;
        //     }
        //     pre[i]=count;
        //     else count

        // }
        int totalOneCount=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                int leftIdx=i-1;
                int rightIdx=i+1;
                int cl=0;
                int cr=0;
                while(leftIdx>=0 && nums[leftIdx]==1){
                    cl++;
                    leftIdx--;
                }
                while(rightIdx<n && nums[rightIdx]==1){
                    cr++;
                    rightIdx++;

                }
                count=Math.max(count,cl+cr);
            }else totalOneCount++;
        }
        if(totalOneCount==n) return n-1;
        if(count==n) return count-1;
        return count;
        
    }
}