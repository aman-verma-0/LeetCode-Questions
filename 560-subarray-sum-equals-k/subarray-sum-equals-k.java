class Solution {
    public int subarraySum(int[] nums, int k) {
        int subArrays=0;
        int n=nums.length;
        int[]prefix=new int[n];
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            prefix[i]=sum;
            if(map.containsKey(prefix[i]-k)){
                subArrays+=map.get(prefix[i]-k);
            }
            map.put(prefix[i],map.getOrDefault(prefix[i],0)+1);
        }
        
        return subArrays;


        
    }
}