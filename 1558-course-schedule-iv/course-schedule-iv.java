class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int p=prerequisites.length;
        int q=queries.length;
        int indeg[]=new int[numCourses];
        List<Boolean>ans=new ArrayList<>();
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<p;i++){
            int u=prerequisites[i][0];
            int v=prerequisites[i][1];
            adj.get(u).add(v);
            indeg[v]++;
        }
        Queue<Integer>queue=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indeg[i]==0) queue.add(i);
        }
        boolean[][]reachable=new boolean[numCourses][numCourses];
        while(!queue.isEmpty()){
            int cur=queue.poll();
            for(int nbr:adj.get(cur)){
                reachable[cur][nbr]=true;
                for(int i=0;i<numCourses;i++){
                    if(reachable[i][cur]){
                        reachable[i][nbr]=true;
                    }
                }
                indeg[nbr]--;
                if(indeg[nbr]==0) queue.add(nbr);
            }
        }
        for(int i=0;i<q;i++){
            int u=queries[i][0];
            int v=queries[i][1];
            ans.add(reachable[u][v]);
        }
        return ans;
    }
    // public boolean dfs(int cur,int target,List<List<Integer>>adj){
    //     for(int nbr:adj.get(cur)){
    //         if(nbr==target) return true;
    //         else if(dfs(nbr,target,adj)) return true;
    //     }
    //     return false;
    // }
}