class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        int[]dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;
        boolean[]vis=new boolean[n];
        vis[0]=true;
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{0,0});
        while(!q.isEmpty()){
            int cur[]=q.poll();
            int idx=cur[0];
            int jump=cur[1];
            for(int j=1;j<=nums[idx];j++){
                int newIdx=idx+j;
                if(newIdx<n && !vis[newIdx] ){
                    vis[newIdx]=true;
                    int newDist=jump+1;
                    if(newDist<dist[newIdx]){
                        dist[newIdx]=newDist;
                        q.add(new int[]{newIdx,newDist});
                    }
                }
            }
        }
        return dist[n-1];


        
    }
}