class Solution {
    public int minimumDeletions(int[] nums) {
        int n=nums.length;
        int mini=Integer.MAX_VALUE;
        int maxi=Integer.MIN_VALUE;
        int minDist=Integer.MAX_VALUE;
        int idx1=0;
        int idx2=0;
        for(int i=0;i<n;i++){
            int num=nums[i];
            if(num>maxi){
                maxi=num;
                idx1=i;
            }
            if(num<mini){
                mini=num;
                idx2=i;
            }
        }

        // remove from front
        int dist1=Math.max(idx1,idx2)+1;
        minDist=Math.min(minDist,dist1);
        
        //remove from last
        int dist2=Math.max(n-idx1,n-idx2);
        minDist=Math.min(minDist,dist2);


        // removing from both side 
        int dist3=idx1+1+n-idx2;
        dist3=Math.min(dist3,(idx2+1+n-idx1));
        minDist=Math.min(minDist,dist3);
        return minDist;



        
    }
}