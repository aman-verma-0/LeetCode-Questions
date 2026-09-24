class Solution {
    public int smallestIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
            String str=Integer.toString(nums[i]);
            int sum=0;
            for(int j=0;j<str.length();j++){
                sum+=str.charAt(j)-'0';              
            }
            if(sum==i) return i;
        }return -1;
        
    }
}