class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        long size=m*k;
        if(size>n) return -1;
        int low=1;
        int high=(int)1e9;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isPossible(mid,m,k,bloomDay)){
                high=mid-1;
                ans=mid;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    public boolean isPossible(int days,int m,int k,int[]bloomDay){
        int totalB=0;
        int flower=0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=days) flower+=1;
            else flower=0;
            if(flower==k){
                totalB++;
                flower=0;    
            }
        }
        if(totalB>=m) return true;
        return false;

    }
}