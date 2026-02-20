class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        List<Integer>ans=new LinkedList<>();
        List<List<Integer>> revList=new ArrayList<>();
        for(int i=0;i<n;i++){
            revList.add(new ArrayList <>());
        }
        int[]indeg=new int[n];
        // int[]outdeg=new int[n];
        boolean[]vis=new boolean[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;j++){
                // outdeg[i]+=1;
                int nbr=graph[i][j];
                indeg[i]+=1;
                revList.get(nbr).add(i);
            }
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indeg[i]==0) q.add(i);
        }
        while(!q.isEmpty()){
            int cur=q.poll();
            ans.add(cur);
            for(int nbr:revList.get(cur)){
                indeg[nbr]--;
                if(indeg[nbr]==0) q.add(nbr);
            }
            
        }
        Collections.sort(ans);
        return ans;
        
        // for(int i=0;i<n;i++){
        //     if(!checkSafe(i,graph)) ans.add(i);

        // }
        // return ans;
        
    }

    // public boolean checkSafe(int i,int[][]graph){
    //     Queue<Integer>q=new LinkedList<>();
    //     boolean[]vis=new boolean[graph.length];
    //     q.add(i);
    //     vis[i]=true;
    //     while(!q.isEmpty()){
    //         int curr=q.poll();
    //         for(int nbr:graph[curr]){
    //             if(vis[nbr]==false){
    //                 vis[nbr]=true;
    //                 q.add(nbr);
    //             }
    //             else return true;
    //         }
    //     }
    //     return false;
    // }
    

}