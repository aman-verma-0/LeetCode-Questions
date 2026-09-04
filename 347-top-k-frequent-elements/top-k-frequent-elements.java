class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;
        int[]ans=new int[k];
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        PriorityQueue<Map.Entry<Integer,Integer>> pq=new PriorityQueue<>((a,b)->b.getValue()-a.getValue());

        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            pq.offer(entry);
        }
        
        for(int i=0;i<k;i++){
            ans[i]=pq.poll().getKey();
        }
        return ans;
    }
}