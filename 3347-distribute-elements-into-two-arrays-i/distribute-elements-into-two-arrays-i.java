class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer> list1=new ArrayList<>();
        list1.add(nums[0]);
        List<Integer> list2=new ArrayList<>();
        list2.add(nums[1]);
        int n=nums.length;
        int[]ans=new int[n];
        for(int i=2;i<n;i++){
            if(list1.get(list1.size()-1)>list2.get(list2.size()-1)){
                list1.add(nums[i]);
            }else{
                list2.add(nums[i]);
            }
        }
        int i=0;
        for(int x:list1){
            ans[i++]=x;
        }
        for(int x:list2){
            ans[i++]=x;
        }
        return ans;

        
    }
}