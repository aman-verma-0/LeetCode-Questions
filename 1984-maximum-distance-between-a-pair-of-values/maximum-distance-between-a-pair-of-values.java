class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        int i=0;
        int j=0;
        int ans=0;
        while(i<n1 && j<n2){
            if(nums1[i]<=nums2[j] && i<=j){
                ans=Math.max(ans,j-i);
                j++;
            }
            else if(nums1[i]>nums2[j] && i<j) i++;
            else if(nums1[i]>nums2[j] && i==j){
                i++;
                j++;
            }

        }return ans;
        
    }
}