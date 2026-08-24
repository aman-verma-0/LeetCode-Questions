class Solution {
    public int stoneGameVIII(int[] stones) {
        int n=stones.length;
        int[]prefixSum=new int[n];
        prefixSum[0]=stones[0];
        for(int i=1;i<n;i++){
            prefixSum[i]=prefixSum[i-1]+stones[i];
        }
        int[] f = new int[n];
        f[n - 1] = prefixSum[n - 1];
        for (int i = n - 2; i >= 1; i--) {
            f[i] = Math.max(f[i + 1], prefixSum[i] - f[i + 1]);
        }
        return f[1];
    }
}