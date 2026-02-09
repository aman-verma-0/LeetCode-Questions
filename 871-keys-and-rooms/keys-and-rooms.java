class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        boolean[]vis=new boolean[n];
        Queue<Integer>q=new LinkedList<>();
        q.add(0);
        vis[0]=true;
        while(!q.isEmpty()){
            int curr=q.poll();
            for(int i=0;i<rooms.get(curr).size();i++){
                int neighbor=rooms.get(curr).get(i);
                if(!vis[neighbor]){
                    vis[neighbor]=true;
                    q.add(neighbor);
                }

            }
        }
        for(int i=0;i<n;i++){
            if(vis[i]==false) return false;
        }
        return true;
    }
}