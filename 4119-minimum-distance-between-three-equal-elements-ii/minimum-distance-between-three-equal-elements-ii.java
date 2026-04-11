class Solution {
    public int minimumDistance(int[] nums) {
        int n=nums.length;
        if(n<3) return -1;
        int[][]arr=new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=nums[i];
            arr[i][1]=i;
        }
        int ans=Integer.MAX_VALUE;
        Arrays.sort(arr,(a,b)->Integer.compare(a[0],b[0]));
        for(int i=2;i<n;i++){
            if(arr[i][0]==arr[i-2][0]){
                int cur=Math.abs(arr[i][1]-arr[i-2][1]);
                ans=Math.min(cur,ans);
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans*2;
        
    }
}