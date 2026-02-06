class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n=nums.length;
        Map<Integer,Integer>map=new HashMap<>();
        map.put(0,1);
        int prefixSum=0,maxLen=0,left=0,right=0;
        while(right<n){
            prefixSum+=nums[right];
            int key=prefixSum%k;
            if(key<0) key+=k;
            if(map.containsKey(key)){
                maxLen+=map.get(key);
                map.put(key,map.get(key)+1);
            }else{
                map.put(key,map.getOrDefault(key,0)+1);
            }
            right++;
        }
        return maxLen;
        
    }
}