class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            int num=nums[i];

            if(list.size()==0 || num>list.get(list.size()-1)){
                list.add(num);
            }
            else{
                int idx=findPos(0,list.size()-1,num,list);
                list.set(idx,num);
            }
        }
        return list.size();

        
    }
    public int findPos(int left,int right,int num,List<Integer> list){
        while(left<right){
            int mid=(left+right)/2;
            if(list.get(mid)==num) return mid;
            else if(list.get(mid)<num){
                left=mid+1;
            }
            else right=mid;
        }
        return left;

    }
}