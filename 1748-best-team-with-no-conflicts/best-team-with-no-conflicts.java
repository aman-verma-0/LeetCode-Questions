class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n=scores.length;
        int[][]pairs=new int[n][2];
        for(int i=0;i<n;i++){
            int score=scores[i];
            int age=ages[i];
            pairs[i][0]=score;
            pairs[i][1]=age;
        }
        Arrays.sort(pairs,(a,b)->{
            if(a[1]==b[1]){
                return a[0]-b[0];
            }
            return a[1]-b[1];
        });
        int[]dp=new int[n];
        int ans=0;
        for(int i=0;i<n;i++){
            dp[i]=pairs[i][0];
            for(int j=0;j<i;j++){
                if(pairs[j][0]<=pairs[i][0]){
                    dp[i]=Math.max(dp[i],dp[j]+pairs[i][0]);
                }
            }
            ans=Math.max(ans,dp[i]);
        }
        return ans;
        
    }
}