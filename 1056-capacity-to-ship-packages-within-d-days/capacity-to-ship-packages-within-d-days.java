class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum=0;
        int low=0;
        for(int x:weights){
            sum+=x;
            low=Math.max(low,x);
        }
        int high=sum;
        int ans=0;
        while(low<=high){
            int mid=(low+high)/2;
            if(isPossible(mid,weights,days)){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;

        
    }
    public boolean isPossible(int capacity,int[]w,int d){
        int n=w.length;
        int dCount=0;
        int wCount=0;
        for(int i=0;i<n;i++){
            if(wCount+w[i]>capacity){
                dCount++;
                wCount=0;
            }
            wCount+=w[i];
        }
        if(wCount>0) dCount++;
        if(dCount<=d) return true;
        return false;
    }
}