class Solution {
    public int findDuplicate(int[] nums) {
        int len=nums.length;
        Set<Integer> set=new HashSet<>();
        for(int num:nums){
            if(set.contains(num)) return num;
            set.add(num);
        }
        return -1;
    }
}