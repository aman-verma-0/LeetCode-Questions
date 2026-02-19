class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        List<Integer>ans=new LinkedList<>();
        List<List<Integer>> revList=new ArrayList<>();
        for(int i=0;i<n;i++){
            revList.add(new ArrayList <>());
        }
        int[]indeg=new int[n];
        int[]outdeg=new int[n];
        boolean[]vis=new boolean[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;j++){
                outdeg[i]+=1;
                int nbr=graph[i][j];
                indeg[nbr]+=1;
                revList.get(nbr).add(i);
            }
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(outdeg[i]==0) q.add(i);
        }
        while(!q.isEmpty()){
            int cur=q.poll();
            ans.add(cur);
            for(int nbr:revList.get(cur)){
                outdeg[nbr]--;
                if(outdeg[nbr]==0) q.add(nbr);
            }
            
        }
        Collections.sort(ans);
        return ans;
        
    }
    // public boolean checkSafe(int i,int[][]graph,int[]indeg,int[]outdeg,boolean[]vis){
    //     Queue<int[]>q=new LinkedList<>();
    //     q.add(new int[]{i,-1});
    //     vis[i]=true;
    //     while(!q.isEmpty()){
    //         int []curr=q.poll();
    //         int node=curr[0];
    //         int par=curr[1];
    //         for(int nbr:graph[node]){
    //             if(vis[nbr]==false){
    //                 vis[nbr]=true;
    //                 q.add(new int[]{nbr,node});
    //             }
    //             else if(par!=nbr) return true;
    //         }
    //     }
    //     return false;


    // }
}