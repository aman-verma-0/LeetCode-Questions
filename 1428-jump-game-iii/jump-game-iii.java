class Solution {
    public boolean canReach(int[] nums, int start) {
        int n=nums.length;
        Queue<Integer>q=new LinkedList<>();
        boolean[]vis=new boolean[n];
        q.add(start);
        vis[start]=true;
        while(!q.isEmpty()){
            int cur=q.poll();
            if(nums[cur]==0) return true;
            int next=cur+nums[cur];
            int prev=cur-nums[cur];
            if(next>=0 && next<n && !vis[next]){
                vis[next]=true;
                q.offer(next);
            }
            if(prev>=0 && prev<n && !vis[prev]){
                vis[prev]=true;
                q.offer(prev);
            }
        }
        return false;
        
    }
}