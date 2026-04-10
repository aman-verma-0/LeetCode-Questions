class Solution {
    public int minimumDistance(int[] nums) {
        int n=nums.length;
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[j]==nums[i]){
                    for(int k=j+1;k<n;k++){
                        if(nums[k]==nums[j]){
                            int curNum=Math.abs(i-j)+Math.abs(j-k)+Math.abs(k-i);
                            ans=Math.min(ans,curNum);
                        }
                    }

                }
                
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
        
    }
}