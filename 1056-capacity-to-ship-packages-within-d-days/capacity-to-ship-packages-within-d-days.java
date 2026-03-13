class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=1;
        long maxCap=weights.length*500;
        int high=(int)maxCap;
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isPossible(mid,days,weights)){
                high=mid-1;
                ans=mid;
            }
            else low=mid+1;
        }
        return ans;
        
    }
    public boolean isPossible(int cap,int days,int[]w){
        int totalW=0;
        int reqDays=0;
        for(int i=0;i<w.length;i++){
            if(w[i]>cap) return false;
            if(totalW+w[i]<=cap){
                totalW+=w[i];
            }
            else{
                reqDays++;
                totalW=w[i];
            }
        }
        reqDays+=1;
        if(reqDays<=days) return true;
        return false;
    }
}