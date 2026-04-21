class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int buyPoint=Integer.MAX_VALUE;
        int ans=0;
        for(int i=0;i<n;i++){
            if(prices[i]<buyPoint){
                buyPoint=prices[i];
            }else{
                ans=Math.max(ans,prices[i]-buyPoint);
            }

        }
        return ans;
        
        
    }
}