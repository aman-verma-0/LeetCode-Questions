class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int n=nums.length;
        int ans=Integer.MAX_VALUE;
        Map<Integer,Integer>map=new HashMap<>();

        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i])){
                ans=Math.min(ans,i-map.get(nums[i]));
            }
            map.put(reverse(nums[i]),i);

        }
        
        return ans==Integer.MAX_VALUE?-1:ans;
        
    }
    public int reverse(int num){
        int newNum=0;
        while(num!=0){
            int rem=num%10;
            newNum=newNum*10+rem;
            num/=10;
        }
        return newNum;
    }
}