class Solution {
    public int minimumCost(int[] cost) {
        int n=cost.length;
        Arrays.sort(cost);
        int minCost=0;
        int noOfCandy=0;
        for(int i=n-1;i>=0;i--){
            if(noOfCandy==2){
                noOfCandy=0;
                continue;    
            }
            if(noOfCandy<2){
                minCost+=cost[i];
                noOfCandy++;
            }
        }
        return minCost;
        
    }
}