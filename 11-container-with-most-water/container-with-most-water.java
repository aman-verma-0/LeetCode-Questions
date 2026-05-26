class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int i=0;
        int j=n-1;
        int ans=0;
        while(i<=j){
            int h=Math.min(height[i],height[j]);
            int len=j-i;
            ans=Math.max(ans,h*len);
            if(height[i]<=height[j]){
                i++;
            }else j--;
        }
        return ans;     
    }
}