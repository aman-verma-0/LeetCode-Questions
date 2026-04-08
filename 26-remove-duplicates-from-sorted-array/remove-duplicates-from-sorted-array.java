class Solution {
    public int removeDuplicates(int[] nums) {
        // LinkedHashSet<Integer>set=new LinkedHashSet<>();
        // int p=nums.length;
        // for (int i=0;i<p;i++){
        //     set.add(nums[i]);

        // }
        // int j=0;
        // int k=set.size();
        // for(int x:set){
        //     nums[j++]=x;
        // }
        // return k;
        int n=nums.length;
        int prev=nums[0];
        int k=1;
        for(int i=0;i<n;i++){
            int cur=nums[i];
            if(cur!=prev){
                prev=cur;
                int temp=cur;
                cur=nums[k];
                nums[k]=temp;
                k++;
            }
        }
        return k;
        
    }
}