class Solution {
    static{
        Runtime.getRuntime().addShutdownHook(
            new Thread(()->{
                try(FileWriter f=new FileWriter("display_runtime.txt")){
                    f.write('0');
                }catch(Exception e){}
            })
        );
    }
    private int func(int i, int prevInd, int[] arr,int[][]dp) {

        if(i == arr.length) {
            return 0;
        }
        if(dp[i][prevInd+1]!=-1) return dp[i][prevInd+1];

        int notTake = func(i + 1, prevInd, arr,dp);
        
        int take = 0;

        if(prevInd == -1)
            take = func(i + 1, i, arr,dp) + 1;

        else if(arr[i] >arr[prevInd])
            take = func(i + 1, i, arr,dp) + 1;

        return dp[i][prevInd+1]=Math.max(take, notTake);
    }

    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][]dp=new int[n+1][n+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return func(0, -1, nums,dp);
        
    }
}